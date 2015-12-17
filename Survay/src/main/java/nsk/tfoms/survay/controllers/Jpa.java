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
import nsk.tfoms.survay.pojo.SearchCriteria;
import nsk.tfoms.survay.service.ClinicService;
import nsk.tfoms.survay.util.Util;

import java.io.File;

@Controller
public class Jpa {
	
  private final String ERROR_MESSAGE = "Неправильно введен логин или пароль.";
  @Autowired private ClinicService personSvc;
  @Autowired private ServletContext servletContext;
  
    
  
  @RequestMapping(value = "/general",method = RequestMethod.GET)
  public String listAll(Model model) {
	File mo = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
	File age = new File( servletContext.getRealPath("/WEB-INF/age.txt"));
	
    model.addAttribute("oneclinic", personSvc.getAll());
	model.addAttribute("listmo", Util.getMo(mo.getPath()));
	model.addAttribute("listage", Util.getMo(age.getPath()));
	
    return "private/general";
  }
  
  @RequestMapping(value = "/addClinic", method = RequestMethod.POST)
  public String addClinic(@Valid SurvayClinic survay, BindingResult binding) {
	 System.out.println("test "+survay.getDataResp());
	
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
  public @ResponseBody nsk.tfoms.survay.pojo.SurvayClinicPojo save(@RequestBody @Valid SurvayClinic survay)
  { 
		nsk.tfoms.survay.pojo.SurvayClinicPojo result = new nsk.tfoms.survay.pojo.SurvayClinicPojo();
	    personSvc.add(survay);
		return result;
  }
  
}
