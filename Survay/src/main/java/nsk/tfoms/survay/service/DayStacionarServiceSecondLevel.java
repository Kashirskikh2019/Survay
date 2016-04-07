package nsk.tfoms.survay.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.secondlevelDayStacionar.DayStacionarSecondlevel;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.QuestionManyDayStacionar;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec15;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec2;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec25;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SurvayClinicDayStacionarSec1;
import nsk.tfoms.survay.pojo.SenderDSSL;
import nsk.tfoms.survay.pojo.WrapManyDSSL;

@Service
public class DayStacionarServiceSecondLevel {
  
  @PersistenceContext
  private EntityManager em;
  
  @SuppressWarnings("unchecked")
  @Transactional
  public List<DayStacionarSecondlevel> getAll(String userp) {
	
	 Query query = em.createQuery("SELECT p FROM DayStacionarSecondlevel p WHERE p.polzSecondleveldaystacionar=:userp ORDER BY p.id DESC");
	 query.setParameter("userp", userp);
	 
	 return query.getResultList();
  }
  
  
  

  
  @Transactional
  public void create(SenderDSSL sender) {
	  
	  DayStacionarSecondlevel survay = sender.getSurvay1();
	  SCDSSLSec2 sec2 = sender.getSurvay3();
	  SurvayClinicDayStacionarSec1 sec1 =  sender.getSurvay2();
	  SCDSSLSec15 sec15 = sender.getSurvay4();
	  SCDSSLSec25 sec25 = sender.getSurvay5();
	  WrapManyDSSL wrap = sender.getSurvay6();

	  
	  Set<QuestionManyDayStacionar> ls = new HashSet<QuestionManyDayStacionar>();
	  QuestionManyDayStacionar temp;
      List<List<String>> listCount = new ArrayList<List<String>>();
      
      List<String> getwrapQuestion14 = wrap.wrapQuestion14();
      listCount.add(getwrapQuestion14);
      List<String> getwrapQuestion16 = wrap.wrapQuestion16();
      listCount.add(getwrapQuestion16);
      List<String> getwrapQuestion18 = wrap.wrapQuestion18();
      listCount.add(getwrapQuestion18);
      List<String> getwrapQuestion19 = wrap.wrapQuestion19();
      listCount.add(getwrapQuestion19);
      List<String> getwrapQuestion21 = wrap.wrapQuestion21();
      listCount.add(getwrapQuestion21);
      List<String> getwrapQuestion22 = wrap.wrapQuestion22();
      listCount.add(getwrapQuestion22);
      List<String> getwrapQuestion24 = wrap.wrapQuestion24();
      listCount.add(getwrapQuestion24);
      
      Comparator<List<String>> comparator = new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o2.size() - o1.size();
			}
  		};
  	
  		Collections.sort(listCount, comparator);
  	
	  	for(int i = 1; i<listCount.get(0).size(); i++)
		{
	  		temp = new QuestionManyDayStacionar();
	  		if(listCount.get(0).get(0).equals("question14")) temp.setQuestionDS14many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question16")) temp.setQuestionDS16many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question18")) temp.setQuestionDS18many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question19")) temp.setQuestionDS19many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question21")) temp.setQuestionDS21many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question22")) temp.setQuestionDS22many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question24")) temp.setQuestionDS24many(listCount.get(0).get(i));
	  		
	  		if(listCount.get(1).size() > i)	{
    			
    			if(listCount.get(1).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(1).get(i));
    		}
	  		
	  		if(listCount.get(2).size() > i)	{
    			
    			if(listCount.get(2).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(2).get(i));
    		}
	  		
	  		if(listCount.get(3).size() > i)	{
    			
    			if(listCount.get(3).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(3).get(i));
    		}
	  		
	  		if(listCount.get(4).size() > i)	{
    			
    			if(listCount.get(4).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(4).get(i));
    		}
	  		
	  		if(listCount.get(5).size() > i)	{
    			
    			if(listCount.get(5).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(5).get(i));
    		}
	  		
	  		if(listCount.get(6).size() > i)	{
    			
    			if(listCount.get(6).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(6).get(i));
    		}
	  		
	  		ls.add(temp);
    		temp.setDaystacionarsecondlevel(survay);
    		this.em.persist(temp);
		}
	        
      
      sec1.setDaystacionarsecondlevel(survay);
      sec2.setDaystacionarsecondlevel(survay);
      sec25.setDaystacionarsecondlevel(survay);
      sec15.setDaystacionarsecondlevel(survay);
      
      survay.setManyDSSL(ls);
      survay.setScdsslsec15(sec15);
      survay.setScdsslsec2(sec2);
      survay.setSurvayclinicdaystacionarSec1(sec1);
      survay.setScdsslsec25(sec25);
	  
	  
	  this.em.persist(survay);
	  
  }
  

  @Transactional
  public List<DayStacionarSecondlevel> getOnId(int id,String userp) {
	  
    List<DayStacionarSecondlevel> result = em.createQuery("SELECT p FROM DayStacionarSecondlevel p WHERE p.polzSecondleveldaystacionar =:userp AND p.id=:id", DayStacionarSecondlevel.class)
    .setParameter("id", id)  
    .setParameter("userp", userp)
    .getResultList();
    return result;
  } 
	

  @Transactional
  public void edit(SenderDSSL sender,HttpServletRequest request) {
	  
	  DayStacionarSecondlevel survay = sender.getSurvay1();
	  /*
		  * Удаляем прежние данные из табдлицы QuestionManyClinic
		  * а далее в нее заливаем новые (отредактированные) 
		  */
		 List<DayStacionarSecondlevel> f = getOnId(survay.getId(),request.getUserPrincipal().getName());
		 Set<QuestionManyDayStacionar> ss = f.get(0).getManyDSSL();
		 Iterator<QuestionManyDayStacionar>  it = ss.iterator();
		 while(it.hasNext()){
			 QuestionManyDayStacionar qq = it.next();
			 qq.setDaystacionarsecondlevel(null);
			 this.em.merge(qq);
			 delete(qq.getIdQuestionManydaystacionar());
		 }
		 //=========================================================================
	  
	  
	  
	  SCDSSLSec2 sec2 = sender.getSurvay3();
	  sec2.setIdSurvayClinicDSSLSec2(sender.getSurvay1().getId());
	  SurvayClinicDayStacionarSec1 sec1 =  sender.getSurvay2();
	  sec1.setIdSurvayClinicDSSec1(sender.getSurvay1().getId());
	  SCDSSLSec15 sec15 = sender.getSurvay4();
	  sec15.setIdSCDSSLSec15(sender.getSurvay1().getId());
	  SCDSSLSec25 sec25 = sender.getSurvay5();
	  sec25.setIdSCDSSLSec25(sender.getSurvay1().getId());
	  
	  WrapManyDSSL wrap = sender.getSurvay6();

	  
	  Set<QuestionManyDayStacionar> ls = new HashSet<QuestionManyDayStacionar>();
	  QuestionManyDayStacionar temp;
      List<List<String>> listCount = new ArrayList<List<String>>();
      
      List<String> getwrapQuestion14 = wrap.wrapQuestion14();
      listCount.add(getwrapQuestion14);
      List<String> getwrapQuestion16 = wrap.wrapQuestion16();
      listCount.add(getwrapQuestion16);
      List<String> getwrapQuestion18 = wrap.wrapQuestion18();
      listCount.add(getwrapQuestion18);
      List<String> getwrapQuestion19 = wrap.wrapQuestion19();
      listCount.add(getwrapQuestion19);
      List<String> getwrapQuestion21 = wrap.wrapQuestion21();
      listCount.add(getwrapQuestion21);
      List<String> getwrapQuestion22 = wrap.wrapQuestion22();
      listCount.add(getwrapQuestion22);
      List<String> getwrapQuestion24 = wrap.wrapQuestion24();
      listCount.add(getwrapQuestion24);
      
      Comparator<List<String>> comparator = new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o2.size() - o1.size();
			}
  		};
  	
  		Collections.sort(listCount, comparator);
  	
	  	for(int i = 1; i<listCount.get(0).size(); i++)
		{
	  		temp = new QuestionManyDayStacionar();
	  		if(listCount.get(0).get(0).equals("question14")) temp.setQuestionDS14many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question16")) temp.setQuestionDS16many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question18")) temp.setQuestionDS18many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question19")) temp.setQuestionDS19many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question21")) temp.setQuestionDS21many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question22")) temp.setQuestionDS22many(listCount.get(0).get(i));
	  		if(listCount.get(0).get(0).equals("question24")) temp.setQuestionDS24many(listCount.get(0).get(i));
	  		
	  		if(listCount.get(1).size() > i)	{
    			
    			if(listCount.get(1).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(1).get(i));
    			if(listCount.get(1).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(1).get(i));
    		}
	  		
	  		if(listCount.get(2).size() > i)	{
    			
    			if(listCount.get(2).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(2).get(i));
    			if(listCount.get(2).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(2).get(i));
    		}
	  		
	  		if(listCount.get(3).size() > i)	{
    			
    			if(listCount.get(3).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(3).get(i));
    			if(listCount.get(3).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(3).get(i));
    		}
	  		
	  		if(listCount.get(4).size() > i)	{
    			
    			if(listCount.get(4).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(4).get(i));
    			if(listCount.get(4).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(4).get(i));
    		}
	  		
	  		if(listCount.get(5).size() > i)	{
    			
    			if(listCount.get(5).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(5).get(i));
    			if(listCount.get(5).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(5).get(i));
    		}
	  		
	  		if(listCount.get(6).size() > i)	{
    			
    			if(listCount.get(6).get(0).equals("question14"))	temp.setQuestionDS14many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question16"))	temp.setQuestionDS16many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question18"))	temp.setQuestionDS18many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question19"))	temp.setQuestionDS19many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question21"))	temp.setQuestionDS21many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question22"))	temp.setQuestionDS22many(listCount.get(6).get(i));
    			if(listCount.get(6).get(0).equals("question24"))	temp.setQuestionDS24many(listCount.get(6).get(i));
    		}
	  		
	  		ls.add(temp);
    		temp.setDaystacionarsecondlevel(survay);
    		//this.em.persist(temp);
		}
	        
      
      sec1.setDaystacionarsecondlevel(survay);
      sec2.setDaystacionarsecondlevel(survay);
      sec25.setDaystacionarsecondlevel(survay);
      sec15.setDaystacionarsecondlevel(survay);
      
      survay.setManyDSSL(ls);
      survay.setScdsslsec15(sec15);
      survay.setScdsslsec2(sec2);
      survay.setSurvayclinicdaystacionarSec1(sec1);
      survay.setScdsslsec25(sec25);
	  
	  
	  this.em.merge(survay);
	  
  }
   
  @Transactional
  public void delete(int id) {
	  QuestionManyDayStacionar questionmanyds = em.find(QuestionManyDayStacionar.class, id);
	  em.remove(questionmanyds);
  } 
}