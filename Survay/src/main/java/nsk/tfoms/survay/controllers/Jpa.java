package nsk.tfoms.survay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.service.ClinicService;

@Controller
@RequestMapping("/general123")
public class Jpa {

  @Autowired private ClinicService personSvc;
  
  @RequestMapping(method = RequestMethod.GET)
  public String listAll(Model model) {
    model.addAttribute("oneclinic", personSvc.getAll());
    return "private/general";
  }
  
  @RequestMapping(value = "/addClinic", method = RequestMethod.POST)
  public String addClinic(@ModelAttribute SurvayClinic survay) {
    personSvc.add(survay);
    return "redirect:/";
  }
}
