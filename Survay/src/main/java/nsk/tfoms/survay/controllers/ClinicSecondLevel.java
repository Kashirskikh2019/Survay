package nsk.tfoms.survay.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import nsk.tfoms.survay.entity.QuestionManyClinic;
import nsk.tfoms.survay.entity.SurvayClinicSec1;
import nsk.tfoms.survay.entity.SurvayClinicSec2;
import nsk.tfoms.survay.entity.SurvayClinicSec25;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.service.ClinicServiceSecondLevel;

/*
 * Контроллер обрабатывает все что связано с анкетой первого уровня АПУ
 
--delete from question_many_clinic t 
--delete from  survay_clinic_secondlevel d 
--delete from  survay_clinic_sec_1 ff 
--delete from  survay_clinic_sec_2 ll 
--delete from   survay_clinic_sec_25 hh
*/

@Controller
public class ClinicSecondLevel {

	  @Autowired private ClinicServiceSecondLevel personSvc;

	  
	  @RequestMapping(value = "/clinicsecondlevel", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
			List<SurvayClinicSecondlevel> list  =	personSvc.getAll(test);
			
		 
		    for (int i = 0; i < list.size(); i++)
		    {
		    	//list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
		    	list.get(i).setReplacementClinicSecondlevelsurvayClinicSec1(list.get(i).getSurvayClinicSec1().getReplacementClinicSecondlevel());
		    	//list.get(i).setSurvayClinicSec1(null);
			}
		    
		    
		    System.out.println("prob " +list);

		    res.setStatus("SUCCESS");
		    res.setResult(list);
		    
		    
			return res;
	  }
	  
	  @RequestMapping(value = "/addsecondclinic", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save() throws ParseException
	  { 
		  
		  
		    nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    personSvc.addTest();
		    List<SurvayClinicSecondlevel> list = personSvc.getAll("tfoms");
		    for (int i = 0; i < list.size(); i++)
		    {
		    	//list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
		    	//list.get(i).setReplacementClinicSecondlevelsurvayClinicSec1(list.get(i).getSurvayClinicSec1().getReplacementClinicSecondlevel());
		    	//list.get(i).setSurvayClinicSec1(null);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

		    System.out.println("list2 " +list);
		    
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
