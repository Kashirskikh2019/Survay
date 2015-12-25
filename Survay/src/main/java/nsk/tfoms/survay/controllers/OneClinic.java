package nsk.tfoms.survay.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.service.ClinicService;

/*
 * Контроллер обрабатывает все что связано с анкетой первого уровня АПУ
 */

@Controller
public class OneClinic {

	  @Autowired private ClinicService personSvc;
	/*  
	  @RequestMapping(value = "/addClinic", method = RequestMethod.POST)
	  public String addClinic(@Valid SurvayClinic survay, BindingResult binding) {
		
	    personSvc.add(survay);
	    return "redirect:general";
	  }
	 */
	  
	  @RequestMapping(value = "/addoneclinic", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestBody @Valid SurvayClinic survay)
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
			// добовляем запись в базу
			System.out.println("ЕЕУЫЕ"+survay);
		    personSvc.add(survay);
		    // вытаскиваем из базы 
		    List<SurvayClinic> list = personSvc.getAll(survay.getPolzovatel());
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/oneclinic", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test)
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayClinic> list = personSvc.getAll(test);
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/oneclinicbetween", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse getDataBetween(@RequestParam String datebegin,String dateend,String userp) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayClinic> list = personSvc.getAllbetween(datebegin, dateend,userp);
		    res.setStatus("SUCCESS");
		    res.setResult(list);
			return res;
	  }
	  
	  @RequestMapping(value = "/onecliniceditid", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse editOnId(@RequestParam String id,String user) throws ParseException
	  { 
		  BigDecimal idBD = new BigDecimal(id.replaceAll(",", ""));
		  
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayClinic> list = personSvc.getOnId(idBD, user);
		    res.setStatus("SUCCESS");
		    System.out.println(list);
		    res.setResult(list);
			return res;
	  }

	
}
