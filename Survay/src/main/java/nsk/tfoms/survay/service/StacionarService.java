package nsk.tfoms.survay.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nsk.tfoms.survay.entity.SurvayStacionar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StacionarService {

	@PersistenceContext
	  private EntityManager em;
	  
	  @Transactional
	  public List<SurvayStacionar> getAll(String userp) {
	    List<SurvayStacionar> result = em.createQuery("SELECT p FROM SurvayStacionar p WHERE p.polzovatelonestac =:userp ORDER BY p.id DESC", SurvayStacionar.class)
	    		.setParameter("userp", userp)
	    		.getResultList();
	    return result;
	  }
	  
	  @Transactional
	  public void add(SurvayStacionar p) {
		  
		  if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
	  }

	  @Transactional
	  public List<SurvayStacionar> getOnId(BigDecimal id,String userp) {
	    List<SurvayStacionar> result = em.createQuery("SELECT p FROM SurvayStacionar p WHERE p.polzovatelonestac =:userp AND p.id=:id", SurvayStacionar.class)
	    .setParameter("id", id)  
	    .setParameter("userp", userp)
	    .getResultList();
	    return result;
	  }
	  
	  @Transactional
	  public List<SurvayStacionar> getAllbetween(String d1, String d2,String userp) {
	    List<SurvayStacionar> result = em.createQuery("SELECT p FROM SurvayStacionar p WHERE p.polzovatelonestac =:userp AND p.dataInputStac BETWEEN :d1 AND :d2 ORDER BY p.id DESC", SurvayStacionar.class)
	    .setParameter("d1", d1)  
	    .setParameter("d2", d2)  
	    .setParameter("userp", userp)
	    .getResultList();
	    return result;
	  }
}
