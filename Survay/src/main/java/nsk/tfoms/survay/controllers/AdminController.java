package nsk.tfoms.survay.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер закрытой страницы.
 * Пример с сайта develnotes.org
 * @author Alex Dl.
 *
 */
@Controller
public class AdminController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listPetits(Map<String, Object> map) {
        return "petit";
    }
}
