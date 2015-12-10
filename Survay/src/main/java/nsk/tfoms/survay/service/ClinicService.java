package nsk.tfoms.survay.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.SurvayClinic;

@Service
public class ClinicService {
  
  @PersistenceContext
  private EntityManager em;
  
  @Transactional
  public List<SurvayClinic> getAll() {
    List<SurvayClinic> result = em.createQuery("SELECT p FROM SurvayClinic p", SurvayClinic.class).getResultList();
    return result;
  }
  
  @Transactional
  public void add(SurvayClinic p) {
    em.persist(p);
  }
}
