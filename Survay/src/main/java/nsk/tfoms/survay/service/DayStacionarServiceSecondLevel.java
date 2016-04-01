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

import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nsk.tfoms.survay.entity.QuestionManyClinic;
import nsk.tfoms.survay.entity.SurvayClinicSec1;
import nsk.tfoms.survay.entity.SurvayClinicSec2;
import nsk.tfoms.survay.entity.SurvayClinicSec25;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.DayStacionarSecondlevel;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec15;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec2;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SCDSSLSec25;
import nsk.tfoms.survay.entity.secondlevelDayStacionar.SurvayClinicDayStacionarSec1;
import nsk.tfoms.survay.pojo.Sender;
import nsk.tfoms.survay.pojo.SenderDSSL;
import nsk.tfoms.survay.pojo.WrapMany;

@Service
public class DayStacionarServiceSecondLevel {
  
  @PersistenceContext
  private EntityManager em;
  

  
  @Transactional
  public void create(SenderDSSL sender) {
	  
	  DayStacionarSecondlevel survay = sender.getSurvay1();
	  SCDSSLSec2 sec2 = sender.getSurvay3();
	  SurvayClinicDayStacionarSec1 sec1 =  sender.getSurvay2();
	  SCDSSLSec15 sec15 = sender.getSurvay4();
	  SCDSSLSec25 sec25 = sender.getSurvay5();
	  
	        
      
      sec1.setDaystacionarsecondlevel(survay);
      sec2.setDaystacionarsecondlevel(survay);
      sec25.setDaystacionarsecondlevel(survay);
      sec15.setDaystacionarsecondlevel(survay);
      
      survay.setScdsslsec15(sec15);
      survay.setScdsslsec2(sec2);
      survay.setSurvayclinicdaystacionarSec1(sec1);
      survay.setScdsslsec25(sec25);
	  
	  
	  this.em.persist(survay);
	  
  }
  

  
	

}