package nsk.tfoms.survay.controllers;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nsk.tfoms.survay.util.Util;

/**
 * Контроллер закрытой страницы.
 * Пример с сайта develnotes.org
 * @author Alex Dl.
 *
 */

@Controller
public class AllController
{
	@Autowired private ServletContext servletContext;
	
	 @RequestMapping(value = "/general",method = RequestMethod.GET)
	  public String listAll(Model model) {
		File mo = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
		File age = new File( servletContext.getRealPath("/WEB-INF/age.txt"));
		
		model.addAttribute("listmo", Util.getMo(mo.getPath()));
		model.addAttribute("listage", Util.getMo(age.getPath()));
		
	    return "private/general";
	  }
}
