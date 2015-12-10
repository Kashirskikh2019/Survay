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
public class AllController {
	
	@RequestMapping(value = "/general", method = RequestMethod.GET)
    public String home() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@ general");
        return "private/general";
    }
}
