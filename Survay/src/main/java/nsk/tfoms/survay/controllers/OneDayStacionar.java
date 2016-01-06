package nsk.tfoms.survay.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayDaystacionar;
import nsk.tfoms.survay.service.DayStacionarService;
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
public class OneDayStacionar {

	  @Autowired private DayStacionarService DayStacionarService;
	  
	  @RequestMapping(value = "/onedaystacionar", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayDaystacionar> list = DayStacionarService.getAll(test);
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespDaystac(	TimesAndDate.parseDate(list.get(i).getDataRespDaystac())	);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/addonedaystac", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestBody @Valid SurvayDaystacionar survayDaystacionar) throws ParseException
	  { 
		    
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
			// добовляем запись в базу
			System.out.println("Model add in db "+survayDaystacionar);
			DayStacionarService.add(survayDaystacionar);
		    // вытаскиваем из базы 
		    List<SurvayDaystacionar> list = DayStacionarService.getAll(survayDaystacionar.getPolzovateldaystacionar());
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespDaystac(	TimesAndDate.parseDate(list.get(i).getDataRespDaystac())	);
			}
		    res.setStatus("SUCCESS");
		    res.setResult(list);

			return res;
	  }
	  
	  @RequestMapping(value = "/onedaystacid", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse editOnId(@RequestParam String id,String user) throws ParseException
	  { 
		  BigDecimal idBD = new BigDecimal(id.replaceAll(",", ""));
		  
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayDaystacionar> list = DayStacionarService.getOnId(idBD, user);
		    list.get(0).setDataInputDaystac(	TimesAndDate.parseDate(list.get(0).getDataRespDaystac())	);
		    res.setStatus("SUCCESS");
		    System.out.println("Edit by id "+list);
		    res.setResult(list);
			return res;
	  }
	  
	  @RequestMapping(value = "/onedaystacbetween", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse getDataBetween(@RequestParam String datebegin,String dateend,String userp) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
		    // вытаскиваем из базы 
		    List<SurvayDaystacionar> list = DayStacionarService.getAllbetween(datebegin, dateend,userp);
		    for (int i = 0; i < list.size(); i++)
		    {
		    	list.get(i).setDataRespDaystac(	TimesAndDate.parseDate(list.get(i).getDataRespDaystac())	);
			}
		    
		    res.setStatus("SUCCESS");
		    res.setResult(list);
			return res;
	  }
	  
}
