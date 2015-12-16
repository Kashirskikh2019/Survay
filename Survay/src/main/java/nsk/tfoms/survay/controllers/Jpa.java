package nsk.tfoms.survay.controllers;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.service.ClinicService;
import nsk.tfoms.survay.util.Util;

import java.io.File;

@Controller
//@RequestMapping("/general")
public class Jpa {
	
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
 
  
  
  
  
  
}
