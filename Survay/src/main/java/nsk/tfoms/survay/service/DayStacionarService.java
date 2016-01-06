package nsk.tfoms.survay.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayDaystacionar;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DayStacionarService {

	@PersistenceContext
	  private EntityManager em;
	  
	  @Transactional
	  public List<SurvayDaystacionar> getAll(String userp) {
	    List<SurvayDaystacionar> result = em.createQuery("SELECT p FROM SurvayDaystacionar p WHERE p.polzovateldaystacionar =:userp ORDER BY p.id DESC", SurvayDaystacionar.class)
	    		.setParameter("userp", userp)
	    		.getResultList();
	    return result;
	  }
	  
	  @Transactional
	  public void add(SurvayDaystacionar p) {
		  
		  if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
	  }

	  @Transactional
	  public List<SurvayDaystacionar> getOnId(BigDecimal id,String userp) {
	    List<SurvayDaystacionar> result = em.createQuery("SELECT p FROM SurvayDaystacionar p WHERE p.polzovateldaystacionar =:userp AND p.id=:id", SurvayDaystacionar.class)
	    .setParameter("id", id)  
	    .setParameter("userp", userp)
	    .getResultList();
	    return result;
	  }
	  
	  @Transactional
	  public List<SurvayDaystacionar> getAllbetween(String d1, String d2,String userp) {
	    List<SurvayDaystacionar> result = em.createQuery("SELECT p FROM SurvayDaystacionar p WHERE p.polzovateldaystacionar =:userp AND p.dataInputDaystac BETWEEN :d1 AND :d2 ORDER BY p.id DESC", SurvayDaystacionar.class)
	    .setParameter("d1", d1)  
	    .setParameter("d2", d2)  
	    .setParameter("userp", userp)
	    .getResultList();
	    return result;
	  }
}
