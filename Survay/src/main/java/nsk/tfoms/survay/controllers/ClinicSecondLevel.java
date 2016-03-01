package nsk.tfoms.survay.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.service.ClinicServiceSecondLevel;
import nsk.tfoms.survay.util.TimesAndDate;

/*
 * Контроллер обрабатывает все что связано с анкетой первого уровня АПУ
 */

@Controller
public class ClinicSecondLevel {

	  @Autowired private ClinicServiceSecondLevel personSvc;

	  
	  @RequestMapping(value = "/clinicsecondlevel", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
			
		    List<SurvayClinicSecondlevel> list =personSvc.getAll(test); 
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
		    	list.get(i).setReplacementClinicSecondlevelsurvayClinicSec1(list.get(i).getSurvayClinicSec1().getReplacementClinicSecondlevel());
		    	list.get(i).setSurvayClinicSec1(null);
			}
		    System.out.println("prob " +list);
		  
		    
		    res.setStatus("SUCCESS");
		    res.setResult(list);

		    
		    
			return res;
	  }
	  
	  /*
	  @RequestMapping(value = "/addsecondclinic", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestBody @Valid SurvayClinicSecondlevel survay) throws ParseException
	  { 
		    
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    personSvc.add(survay);
		    List<SurvayClinicSecondlevel> list = personSvc.getAll(survay.getPolzovatelSecondlevel());
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

		    System.out.println("list2 " +list);
		    
			return res;
	  }
	*/
}
