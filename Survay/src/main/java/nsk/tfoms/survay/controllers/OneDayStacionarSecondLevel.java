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
import org.springframework.web.bind.annotation.ResponseBody;

import nsk.tfoms.survay.entity.SurvayClinicSecondlevel;
import nsk.tfoms.survay.pojo.SenderDSSL;
import nsk.tfoms.survay.service.DayStacionarServiceSecondLevel;

@Controller
public class OneDayStacionarSecondLevel {

	@Autowired DayStacionarServiceSecondLevel personSvc;
	
	@RequestMapping(value = "/adddssl", method = RequestMethod.POST)
	  public @ResponseBody nsk.tfoms.survay.util.JsonResponse save(HttpServletRequest request) throws ParseException, IOException
	  { 
		    
			  nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();

			  // 1. get received JSON data from request
		      BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		      String json = "";
		      if(br != null){ json = br.readLine(); }
		      br.close();
		      
		      String fg = URLEncoder.encode(json, "Cp1251");
		      String fg2 = URLDecoder.decode(fg, "UTF-8");
		      
		      // 2. initiate jackson mapper
		      ObjectMapper mapper = new ObjectMapper();
		      // 3. Convert received JSON to Article
		      SenderDSSL sender = mapper.readValue(fg2, SenderDSSL.class);
		      
		      if(sender.getSurvay1().getId() == null) personSvc.create(sender);
		     // else personSvc.edit(sender,request);
			
		    List<SurvayClinicSecondlevel> list = new ArrayList<SurvayClinicSecondlevel>();//personSvc.getAll(sender.getSurvay1().getPolzovatelSecondlevel());
		    
		    res.setStatus("SUCCESS");
		    res.setResult(list);

		    
			return res;
	  }
	
}
