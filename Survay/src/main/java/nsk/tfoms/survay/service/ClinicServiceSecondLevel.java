package nsk.tfoms.survay.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.QuestionManyClinic;
import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayClinicSec1;
import nsk.tfoms.survay.entity.SurvayClinicSec2;
import nsk.tfoms.survay.entity.SurvayClinicSec25;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.util.WrapSurvayClinicSecondlevel;

@Service
public class ClinicServiceSecondLevel {
  
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<SurvayClinicSecondlevel> getAll(String userp) {
	  
	/*List<SurvayClinicSecondlevel> result = em.createQuery("SELECT p FROM SurvayClinicSecondlevel p WHERE p.polzovatelSecondlevel=:userp ORDER BY p.id DESC", SurvayClinicSecondlevel.class)
	.setParameter("userp", userp)
	.getResultList();
	return result;*/
	 Query query = em.createQuery("SELECT p FROM SurvayClinicSecondlevel p WHERE p.polzovatelSecondlevel=:userp ORDER BY p.id DESC");
	 query.setParameter("userp", userp);
	 
	 return query.getResultList();
  }
  
  @Transactional
  public void add(SurvayClinicSecondlevel p) {
	  
	  if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
  }
  
  @Transactional
  public void addTest() {
	  
	  SurvayClinicSec1 sc = new SurvayClinicSec1();
	  sc.setReplacementClinicSecondlevel("Нет");
	  
	  SurvayClinicSec2 sc2 = new SurvayClinicSec2();
	  sc2.setQuestion20_1_clinic("2");
	  
	  SurvayClinicSec25 sc25 = new SurvayClinicSec25();
	  sc25.setQuestion25_1_clinic("25");
	  
	  QuestionManyClinic qmc = new QuestionManyClinic();
	  qmc.setQuestion12_clinic("тест1");
	  QuestionManyClinic qmc2 = new QuestionManyClinic();
	  qmc2.setQuestion12_clinic("тест2");
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
	  
	  this.em.persist(survay);
	  this.em.persist(qmc2);
	  this.em.persist(qmc);
	  
	  //if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
  }
  
}
