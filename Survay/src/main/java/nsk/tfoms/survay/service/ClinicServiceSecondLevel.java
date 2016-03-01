package nsk.tfoms.survay.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.util.WrapSurvayClinicSecondlevel;

@Service
public class ClinicServiceSecondLevel {
  
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<SurvayClinicSecondlevel> getAll(String userp) {
	  
	userp = "yhfg";
	  
	/*List<SurvayClinicSecondlevel> result = em.createQuery("SELECT p FROM SurvayClinicSecondlevel p WHERE p.polzovatelSecondlevel=:userp ORDER BY p.id DESC", SurvayClinicSecondlevel.class)
	.setParameter("userp", userp)
	.getResultList();
	return result;*/
	 Query query = em.createQuery("SELECT p FROM SurvayClinicSecondlevel p left join fetch p.survayClinicSec1  WHERE p.polzovatelSecondlevel=:userp ORDER BY p.id DESC");
	 query.setParameter("userp", userp);
	 
	 return query.getResultList();
  }
  
  @Transactional
  public void add(SurvayClinicSecondlevel p) {
	  
	  if (p.getId() == null) {this.em.persist(p);} else {this.em.merge(p);}
  }
  
}
