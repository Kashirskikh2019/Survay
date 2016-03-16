package nsk.tfoms.survay.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;

import nsk.tfoms.survay.entity.QuestionManyClinic;
import nsk.tfoms.survay.entity.SurvayClinicSec1;
import nsk.tfoms.survay.entity.SurvayClinicSec2;
import nsk.tfoms.survay.entity.SurvayClinicSec25;
import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.pojo.Sender;
import nsk.tfoms.survay.pojo.WrapMany;
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

		    res.setStatus("SUCCESS");
		    res.setResult(list);
		    
		    
			return res;
	  }
	  
	  @RequestMapping(value = "/addsecondclinictest", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save() throws ParseException
	  { 
		  
		  
		    nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		  /*  personSvc.addTest();
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
		    */
			return res;
	  }
	  
	  
	  
	  @RequestMapping(value = "/addsecondclinic", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(HttpServletRequest request) throws ParseException, IOException
	  { 
		    
			  nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();

			  // 1. get received JSON data from request
		      BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		      String json = "";
		      if(br != null){ json = br.readLine(); }
		      br.close();
		      
		      String fg = URLEncoder.encode(json, "Cp1251");
		      String fg2 = URLDecoder.decode(fg, "UTF-8");
		      
		      // 2. initiate jackson mapper
		      ObjectMapper mapper = new ObjectMapper();
		      // 3. Convert received JSON to Article
		      Sender sender = mapper.readValue(fg2, Sender.class);
		      
		      System.out.println("test - "+ fg2);
		      System.out.println("test2 - "+ sender);
		      System.out.println("test3 - "+ sender.getSurvay1());
		      System.out.println("test3 - "+ sender.getSurvay5());
		      
		      
		      personSvc.addTest(sender);
			
		  // personSvc.add(survay1);
		    List<SurvayClinicSecondlevel> list = new ArrayList<SurvayClinicSecondlevel>();//personSvc.getAll(survay.getPolzovatelSecondlevel());
		    /*for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
			}*/
		    
		    res.setStatus("SUCCESS");
		    res.setResult(list);

		    
			return res;
	  }
	
}
