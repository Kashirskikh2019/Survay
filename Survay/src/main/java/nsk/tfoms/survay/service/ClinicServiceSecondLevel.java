package nsk.tfoms.survay.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.QuestionManyClinic;
import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayClinicSec1;
import nsk.tfoms.survay.entity.SurvayClinicSec2;
import nsk.tfoms.survay.entity.SurvayClinicSec25;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.pojo.Sender;
import nsk.tfoms.survay.pojo.WrapMany;
import nsk.tfoms.survay.util.WrapSurvayClinicSecondlevel;

@Service
public class ClinicServiceSecondLevel {
  
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<SurvayClinicSecondlevel> getAll(String userp) {
	
	 Query query = em.createQuery("SELECT p FROM SurvayClinicSecondlevel p WHERE p.polzovatelSecondlevel=:userp ORDER BY p.id DESC");
	 query.setParameter("userp", userp);
	 
	 return query.getResultList();
  }
  
  @Transactional
  public void add(SurvayClinicSecondlevel p) {
	  
	  if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
  }
  
  @Transactional
  public void addTest(Sender sender) {
	  
	/*  SurvayClinicSec1 sc = new SurvayClinicSec1();
	  sc.setReplacementClinicSecondlevel("Нет");
	  
	  SurvayClinicSec2 sc2 = new SurvayClinicSec2();
	  sc2.setQuestion20_1_clinic("2");
	  
	  SurvayClinicSec25 sc25 = new SurvayClinicSec25();
	  sc25.setQuestion25_1_clinic("25");
	  
	  QuestionManyClinic qmc = new QuestionManyClinic();
	  qmc.setQuestion2_clinic("тест1");
	  QuestionManyClinic qmc2 = new QuestionManyClinic();
	  qmc2.setQuestion2_clinic("тест2");
//----------------------------------------------------------------------------------- 
	  SurvayClinicSecondlevel survay = new SurvayClinicSecondlevel();
	  survay.setAgeSecondlevel(55);	
	  survay.setDataInputSecondlevel("22.01.2014");
	  survay.setDataRespSecondlevel("");
	  survay.setMoSecondlevel("dfsdfsdf");
	  survay.setPolzovatelSecondlevel("tfoms");
	  survay.setSexSecondlevel("мужской");
	  survay.setVisitClinicSecondlevel("");

	  Set<QuestionManyClinic> ls = new HashSet<QuestionManyClinic>();
	  ls.add(qmc);ls.add(qmc2);
	  
	  survay.setSurvayClinicSec1(sc);
	  survay.setSurvayClinicSec2(sc2);
	  survay.setSurvayClinicSec25(sc25);
	  survay.setQuestion_many(ls);
	  
	  sc.setSurvayClinicSecondlevel(survay);
	  sc2.setSurvayClinicSecondlevel(survay);
	  sc25.setSurvayClinicSecondlevel(survay);
	  qmc.setSurvayClinicSecondlevel(survay);
	  qmc2.setSurvayClinicSecondlevel(survay);
	  */
	  /* Дано: В тесте есть 5-7 вопросов. На каждый вопрос может быть несколько ответов
	   * Проблема: При добавлении в базу добовляется только один вопрос т.е.
	   * 
	   * id записи	|	Столбец2	|	Столбец3	|	id ключа	|
	   * 123			запись1							789
	   * 124			запись2							789
	   * 125			запись3							789
	   * 126							запись1			789
	   * 127							запись2			789
	   * 128							запись3			789
	   * 
	   * >>>>>>>>>>>>>>>>>>>А НАДО
	   * 
	   * id записи	|	Столбец2	|	Столбец3	|	id ключа	|
	   * 123			запись1			запись1			789
	   * 124			запись2			запись2			789
	   * 125			запись3			запись3			789
	   * 
	   * Решение:
	   * 	1.	Находим вопрос с наибольшим количеством ответов. Сколько ответов столько созданим строк в базе 
	   * 	2.	Создав строку добовляем в нее вопросы по ключу. Т.е. будем бегать ЦИКЛОМ по такой абстракции
	   * 
	   *  								|	вопрос1/строка	|	вопрос2		|	вопрос3	|
	   *  new QuestionManyClinic()			set1(текст1)	 set2(текст2)	  se3t(текст3)
	   *  new QuestionManyClinic()			set1(текст1)	 set2(текст2)	  		
	   *  new QuestionManyClinic()			set1(текст1)	 	  
	   *  
	   */
	  
	  SurvayClinicSecondlevel survay = sender.getSurvay1();
	  WrapMany mod = sender.getSurvay5();
	  SurvayClinicSec2 sec2 = sender.getSurvay3();
	  SurvayClinicSec1 sec1 =  sender.getSurvay2();
	  SurvayClinicSec25 sec25 = sender.getSurvay4();
	  
	  /*
	   * создаем QuestionManyClinic и присваеваем из WrapMany не пустые значения одного поля
	   * т.е. а анкете (по дному вопросу) было проставлено 3 галочки...сервер обворачивает(собирает все несколько вариантов  этого  вопроса(это происходит в классе WrapMany))
	   *  и уже здесь, в цикле каждый варианты ответа на один вопрос добовляется в базу по правилам добовления one to many
	   */
	  Set<QuestionManyClinic> ls = new HashSet<QuestionManyClinic>();
      QuestionManyClinic temp;
      
      List<List<String>> listCount = new ArrayList<List<String>>();
      
      List<String> getwrapQuestion2 = mod.wrapQuestion2();
      listCount.add(getwrapQuestion2);
      List<String> getwrapQuestion6_1 = mod.wrapQuestion6_1();
      listCount.add(getwrapQuestion6_1);
      List<String> getwrapQuestion6_2 = mod.wrapQuestion6_2();
      listCount.add(getwrapQuestion6_2);
      List<String> getwrapQuestion24 = mod.wrapQuestion24();
      listCount.add(getwrapQuestion24);
      List<String> getwrapQuestion26 = mod.wrapQuestion26();
      listCount.add(getwrapQuestion26);
      
      Comparator<List<String>> comparator = new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o2.size() - o1.size();
			}
    	};
    	
    	Collections.sort(listCount, comparator); 
    	System.out.println("listCount "+listCount);
    	
    	// количество строк в бд будет соответствовать количеству ответов на  вопрос (который выбран по принципу максимального киличества ответов в каждом вопросе) 
    	for(int i = 1; i<listCount.get(0).size(); i++)
    	{
    		// создаем объект (количество объектов зависит от максимально-отвеченного относительно вариантов ответа, вопроса)
    		temp = new QuestionManyClinic();
    		
    		/* подставляем из отсортированного listCount вопрос с наибольшим количеством ответов (в вопросе может быть неслько ответов)
    		 * определив какой вопрос с наибольши количеством  по listCount.get(0).get(0).equals("question2") и  определяем ему соответствующий сеттер
    		 * i=1 так первым элементом идет ключ - название вопроса: question2 или question6_1 или question6_2
    		 */
    		if(listCount.get(0).get(0).equals("question2")) temp.setQuestion2_clinic(listCount.get(0).get(i));
    		if(listCount.get(0).get(0).equals("question6_1")) temp.setQuestion6_1_clinic(listCount.get(0).get(i));
    		if(listCount.get(0).get(0).equals("question6_2")) temp.setQuestion6_2_clinic(listCount.get(0).get(i));
    		if(listCount.get(0).get(0).equals("question24")) temp.setQuestion24_clinic(listCount.get(0).get(i));
    		if(listCount.get(0).get(0).equals("question26")) temp.setQuestion26_clinic(listCount.get(0).get(i));
    		
    		// если вариантов ответа в вопросе отсортированном в позиции 1 больше чем элемент который требуется
    		// т.е. в массиве 0	1 (2 элемента) а i=2...то будет исключение
    		if(listCount.get(1).size() > i)	{
    			
    			if(listCount.get(1).get(0).equals("question2"))	temp.setQuestion2_clinic(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question6_1")) temp.setQuestion6_1_clinic(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question6_2")) temp.setQuestion6_2_clinic(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question24")) temp.setQuestion24_clinic(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question26")) temp.setQuestion26_clinic(listCount.get(1).get(i));
    		}
    		
			if(listCount.get(2).size() > i)	{
			    			
			    			if(listCount.get(2).get(0).equals("question2"))	temp.setQuestion2_clinic(listCount.get(2).get(i));
			    			if(listCount.get(2).get(0).equals("question6_1")) temp.setQuestion6_1_clinic(listCount.get(2).get(i));
			    			if(listCount.get(2).get(0).equals("question6_2")) temp.setQuestion6_2_clinic(listCount.get(2).get(i));
			    			if(listCount.get(2).get(0).equals("question24")) temp.setQuestion24_clinic(listCount.get(2).get(i));
			    			if(listCount.get(2).get(0).equals("question26")) temp.setQuestion26_clinic(listCount.get(2).get(i));
			    		}
			
			if(listCount.get(3).size() > i)	{
    			
    			if(listCount.get(3).get(0).equals("question2"))	temp.setQuestion2_clinic(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question6_1")) temp.setQuestion6_1_clinic(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question6_2")) temp.setQuestion6_2_clinic(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question24")) temp.setQuestion24_clinic(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question26")) temp.setQuestion26_clinic(listCount.get(3).get(i));
    		}
			
			if(listCount.get(4).size() > i)	{
    			
    			if(listCount.get(4).get(0).equals("question2"))	temp.setQuestion2_clinic(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question6_1")) temp.setQuestion6_1_clinic(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question6_2")) temp.setQuestion6_2_clinic(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question24")) temp.setQuestion24_clinic(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question26")) temp.setQuestion26_clinic(listCount.get(4).get(i));
    		}
    		
    		
    		ls.add(temp);
    		temp.setSurvayClinicSecondlevel(survay);
    		this.em.persist(temp);
    		
    	}
      
      System.out.println("ls "+ ls+" => "+ ls.size());
      
      /*      
      
 		
      
      sec1.setSurvayClinicSecondlevel(survay);
      sec2.setSurvayClinicSecondlevel(survay);
      sec25.setSurvayClinicSecondlevel(survay);
      
      survay.setQuestion_many(ls);
      survay.setSurvayClinicSec1(sec1);
      survay.setSurvayClinicSec2(sec2);
      survay.setSurvayClinicSec25(sec25);
	  
	  */
	  this.em.persist(survay);
	  //this.em.persist(qmc2);
	  //this.em.persist(qmc);
	  
	  //if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
  }
  
	

}