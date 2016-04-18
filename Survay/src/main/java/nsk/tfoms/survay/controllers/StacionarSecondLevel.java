package nsk.tfoms.survay.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nsk.tfoms.survay.entity.secondlevel.DayStacionar.DayStacionarSecondlevel;
import nsk.tfoms.survay.pojo.SenderDSSL;
import nsk.tfoms.survay.service.DayStacionarServiceSecondLevel;

@Controller
public class StacionarSecondLevel {

	@Autowired DayStacionarServiceSecondLevel personSvcDssl;
	
	@RequestMapping(value = "/allssl", method = RequestMethod.GET)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(@RequestParam String test) throws ParseException
	  { 
			nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
			List<DayStacionarSecondlevel> list  = new ArrayList<DayStacionarSecondlevel>();	//personSvcDssl.getAll(test);
		 
		    for (int i = 0; i < list.size(); i++)
		    {
		    	//list.get(i).setDataRespSecondlevel(	TimesAndDate.parseDate(list.get(i).getDataRespSecondlevel())	);
		    	//list.get(i).setReplacementClinicSecondlevelsurvayClinicSec1(list.get(i).getSurvayClinicSec1().getReplacementClinicSecondlevel());
		    	//list.get(i).setSurvayClinicSec1(null);
			}

		    res.setStatus("SUCCESS");
		    res.setResult(list);
		    
		    
			return res;
	  }

	
		
}
