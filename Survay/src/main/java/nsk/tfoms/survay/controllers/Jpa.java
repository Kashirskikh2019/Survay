package nsk.tfoms.survay.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.fields.Fields;
import nsk.tfoms.survay.service.ClinicService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

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
	model.addAttribute("listmo", getMo(mo.getPath()));
	model.addAttribute("listage", getMo(age.getPath()));
	
    return "private/general";
  }
  
  @RequestMapping(value = "/addClinic", method = RequestMethod.POST)
  public String addClinic(@ModelAttribute SurvayClinic survay) {
    personSvc.add(survay);
    return "redirect:general";
  }
  
  
  public static Map<Integer, String> getMo(String st)
  {
		return getProperties(st);
  }
	
	private static Map<Integer, String> getProperties(String filename) 
	{
		Properties prop = new Properties();
		Map<Integer, String> map = new TreeMap<Integer, String>(
					new Comparator<Integer>() {
		 
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
		 
				});
		try {
		    InputStream stream = new FileInputStream(new File(filename));
		    InputStreamReader  reader = new InputStreamReader(stream,"UTF-8");
			prop.load(reader);
	
			Enumeration e = prop.keys();
			while(e.hasMoreElements()) {
				String key = (String)e.nextElement();
				map.put(Integer.parseInt(key), prop.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}
  
  
  
  
}
