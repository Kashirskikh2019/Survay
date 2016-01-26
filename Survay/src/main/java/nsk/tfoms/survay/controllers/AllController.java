package nsk.tfoms.survay.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import nsk.tfoms.survay.entity.SurvayClinic;
import nsk.tfoms.survay.entity.SurvayDaystacionar;
import nsk.tfoms.survay.entity.SurvayStacionar;
import nsk.tfoms.survay.pojo.ParamOnePart;
import nsk.tfoms.survay.service.ClinicService;
import nsk.tfoms.survay.service.DayStacionarService;
import nsk.tfoms.survay.service.StacionarService;
import nsk.tfoms.survay.util.TimesAndDate;
import nsk.tfoms.survay.util.Util;
import nsk.tfoms.survay.util.report.Reports;



@Controller
public class AllController
{
	@Autowired private ServletContext servletContext;
	
	@Autowired private DayStacionarService daystacionarservice;
	@Autowired private StacionarService stacionarservice;
	@Autowired private ClinicService personSvc;
	
    private static final int BUFFER_SIZE = 4096;
    
    
	@RequestMapping(value = "/general",method = RequestMethod.GET)
	  public String listAll(Model model){
		File mo = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
		File age = new File( servletContext.getRealPath("/WEB-INF/age.txt"));
		
		model.addAttribute("listmo", Util.getMo(mo.getPath()));
		model.addAttribute("listage", Util.getMo(age.getPath()));
		
	    return "private/general";
	}
	
	
	@RequestMapping(value = "/download",method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
     
		String filePath  = "/downloads/"+request.getSession().getAttribute("filename");
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");

		// construct the complete absolute path of the file
		String fullPath = appPath + filePath;		
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inputStream.close();
		outStream.close();
		
		new File(fullPath).delete();
     
	}
	 
	
	
	/**
     * Method for handling file download request from client
     */
    @RequestMapping(value = "/firstPartReport",method = RequestMethod.POST)
    public @ResponseBody nsk.tfoms.survay.util.JsonResponse doDownload(HttpServletRequest request,HttpServletResponse response,
    		@RequestBody ParamOnePart paramonepart) throws IOException {
    	
    	nsk.tfoms.survay.util.JsonResponse res = new nsk.tfoms.survay.util.JsonResponse();
       
    	List<List<SurvayClinic>> forOneOrgClinic = null;
    	List<List<SurvayDaystacionar>> forOneOrgDayStac = null;
    	List<List<SurvayStacionar>> forOneOrgStac = null;
    	
    	if(! parseorg(paramonepart).equals("bad"))
    	{
    		System.out.println("===================Clinic================================");
		    List<SurvayClinic> list1 = personSvc.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 59);
		    List<SurvayClinic> list2 = personSvc.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 54);
		    List<SurvayClinic> list3 = personSvc.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 60);
		    List<SurvayClinic> list4 = personSvc.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 55);

		    forOneOrgClinic = new ArrayList<List<SurvayClinic>>();
		    forOneOrgClinic.add(list1);
		    forOneOrgClinic.add(list2);
		    forOneOrgClinic.add(list3);
		    forOneOrgClinic.add(list4);

		    System.out.println("=============================DayStacionar===============================");
		    List<SurvayDaystacionar> list5 = daystacionarservice.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 59);
		    List<SurvayDaystacionar> list6 = daystacionarservice.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 54);
		    List<SurvayDaystacionar> list7 = daystacionarservice.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 60);
		    List<SurvayDaystacionar> list8 = daystacionarservice.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 55);
		    
		    forOneOrgDayStac = new ArrayList<List<SurvayDaystacionar>>();
		    forOneOrgDayStac.add(list5);
		    forOneOrgDayStac.add(list6);
		    forOneOrgDayStac.add(list7);
		    forOneOrgDayStac.add(list8);
		    
		    
		    System.out.println("=========================================Stacionar==========================");
		    List<SurvayStacionar> list9 = stacionarservice.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 59);
		    List<SurvayStacionar> list10 = stacionarservice.getReportLess(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 54);
		    List<SurvayStacionar> list11 = stacionarservice.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Мужской", 60);
		    List<SurvayStacionar> list12 = stacionarservice.getReportMore(paramonepart.getDatestart(), paramonepart.getDateend(), parseorg(paramonepart), "Женский", 55);

		    forOneOrgStac = new ArrayList<List<SurvayStacionar>>();
		    forOneOrgStac.add(list9);
		    forOneOrgStac.add(list10);
		    forOneOrgStac.add(list11);
		    forOneOrgStac.add(list12);
		    
		    new Reports().loadToExcelResalt(forOneOrgClinic,forOneOrgDayStac,forOneOrgStac,request, parseorg(paramonepart));
    	}
    	else
    	{
    		// реализация для выделенных несколькох checkbox'ов  тфомс ингос
    	}
	    
    	
    	
	    
	    res.setStatus("SUCCESS");
	    res.setResult(new String("Ok"));

		return res; 
        
    }
    
    
    /*
     * Method being search only once organizacion and pass resalt to return
     * 1 - tfoms
     * 2 - ingos
     * 3 - simaz
     * 4 - rosno  
     */
    private String parseorg(ParamOnePart paramonepart)
    {
        int i = 0;	
        int j = 0;
    	if(paramonepart.getOnefoms().equals("true")){	i=i+1;	j = 1;}
    	if(paramonepart.getOneingos().equals("true")){	i=i+1;	j = 2;}
    	if(paramonepart.getOnesimaz().equals("true")){	i=i+1;	j = 3;}
    	if(paramonepart.getOnerosno().equals("true")){	i=i+1;	j = 4;}
    	
    	if(i == 1 && j == 1){ return "tfoms"; }
    	if(i == 1 && j == 2){ return "ingos"; }
    	if(i == 1 && j == 3){ return "simaz"; }
    	if(i == 1 && j == 4){ return "rosno"; }
    	
    	return "bad";
    }
    
    
    private void  count(List<Object> list)
    {
    	for(int i = 0; i<list.size();i++)
    	{
    		Object t = list.get(0);
    		
    	}
    	
       
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
}
