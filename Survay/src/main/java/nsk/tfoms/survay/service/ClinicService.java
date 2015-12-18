package nsk.tfoms.survay.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.SurvayClinic;

@Service
public class ClinicService {
  
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<SurvayClinic> getAll() {
    List<SurvayClinic> result = em.createQuery("SELECT p FROM SurvayClinic p ORDER BY p.id DESC", SurvayClinic.class).getResultList();
    return result;
  }
  
  @Transactional
  public List<SurvayClinic> getAllbetween(String d1, String d2) {
    List<SurvayClinic> result = em.createQuery("SELECT p FROM SurvayClinic p WHERE p.dataInput BETWEEN :d1 AND :d2 ORDER BY p.id DESC", SurvayClinic.class)
    .setParameter("d1", d1)  
    .setParameter("d2", d2)  
    .getResultList();
    return result;
  }
  @Transactional
  public void add(SurvayClinic p) {
    em.persist(p);
    System.out.println("@@ "+p);
  }
}
