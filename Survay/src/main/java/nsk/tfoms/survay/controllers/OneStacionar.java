package nsk.tfoms.survay.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayDaystacionar;
import nsk.tfoms.survay.entity.SurvayStacionar;
import nsk.tfoms.survay.service.DayStacionarService;
import nsk.tfoms.survay.service.StacionarService;
import nsk.tfoms.survay.util.TimesAndDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Контроллер обрабатывает все что связано с анкетой первого уровня Дневного стационара
 */

@Controller
public class OneStacionar {

	  @Autowired private StacionarService stacionarService;
	  
	  @RequestMapping(value = "/onestacionar", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayStacionar> list = stacionarService.getAll(test);
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespStac(	TimesAndDate.parseDate(list.get(i).getDataRespStac())	);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/addonestac", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestBody @Valid SurvayStacionar survaystacionar) throws ParseException
	  { 
		    
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
			// добовляем запись в базу
			System.out.println("Model add in db "+survaystacionar);
			stacionarService.add(survaystacionar);
		    // вытаскиваем из базы 
		    List<SurvayStacionar> list = stacionarService.getAll(survaystacionar.getPolzovatelonestac());
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespStac(	TimesAndDate.parseDate(list.get(i).getDataRespStac())	);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/onestacid", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse editOnId(@RequestParam String id,String user) throws ParseException
	  { 
		  BigDecimal idBD = new BigDecimal(id.replaceAll(",", ""));
		  
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayStacionar> list = stacionarService.getOnId(idBD, user);
		    list.get(0).setDataRespStac(	TimesAndDate.parseDate(list.get(0).getDataRespStac())	);
		    res.setStatus("SUCCESS");
		    System.out.println("Edit by id "+list);
		    res.setResult(list);
			return res;
	  }
	  
	  @RequestMapping(value = "/onestacbetween", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse getDataBetween(@RequestParam String datebegin,String dateend,String userp) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayStacionar> list = stacionarService.getAllbetween(datebegin, dateend,userp);
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespStac(	TimesAndDate.parseDate(list.get(i).getDataRespStac())	);
			}
		    
		    res.setStatus("SUCCESS");
		    res.setResult(list);
			return res;
	  }
	  
}
