package nsk.tfoms.survay.controllers;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.service.ClinicService;
import nsk.tfoms.survay.util.Util;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Controller
public class Jpa {
	
  private final String ERROR_MESSAGE = "Неправильно введен логин или пароль.";
  @Autowired private ClinicService personSvc;
  @Autowired private ServletContext servletContext;
  
    
  
  @RequestMapping(value = "/general",method = RequestMethod.GET)
  public String listAll(Model model) {
	File mo = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
	File age = new File( servletContext.getRealPath("/WEB-INF/age.txt"));
	
	model.addAttribute("listmo", Util.getMo(mo.getPath()));
	model.addAttribute("listage", Util.getMo(age.getPath()));
	
    return "private/general";
  }
  
  @RequestMapping(value = "/addClinic", method = RequestMethod.POST)
  public String addClinic(@Valid SurvayClinic survay, BindingResult binding) {
	
    personSvc.add(survay);
    return "redirect:general";
  }
 
  
  @RequestMapping(value = "/getCharNum", method = RequestMethod.GET)
	public @ResponseBody nsk.tfoms.survay.pojo.Response getCharNum(@RequestParam String text)
  { 
		nsk.tfoms.survay.pojo.Response result = new nsk.tfoms.survay.pojo.Response();
		if (text != null) {
			result.setText(text);
			result.setCount(text.length());
		}
		return result;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home()
  {
	  return "redirect:general";
  }
  	
  	@RequestMapping(value = "/login", method = RequestMethod.GET)
  	public String login() {
  		return "login";
  	}

  	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
  	public String loginerror(ModelMap model) {
  		model.addAttribute("error", ERROR_MESSAGE);
  		return "login";
  	}

  	@RequestMapping(value = "/logout", method = RequestMethod.GET)
  	public String logout() {
  		return "login";
  	}
  
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
