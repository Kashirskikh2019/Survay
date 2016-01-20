package nsk.tfoms.survay.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

import nsk.tfoms.survay.pojo.ParamOnePart;
import nsk.tfoms.survay.util.Util;



@Controller
public class AllController
{
	@Autowired private ServletContext servletContext;
	
    private static final int BUFFER_SIZE = 4096;
    
   
             
    private String filePath = "/downloads/SpringProject.zip";
	@RequestMapping(value = "/general",method = RequestMethod.GET)
	  public String listAll(Model model){
		File mo = new File( servletContext.getRealPath("/WEB-INF/mo.txt"));
		File age = new File( servletContext.getRealPath("/WEB-INF/age.txt"));
		
		model.addAttribute("listmo", Util.getMo(mo.getPath()));
		model.addAttribute("listage", Util.getMo(age.getPath()));
		
	    return "private/general";
	}
	 
	
	
	/**
     * Method for handling file download request from client
     */
    @RequestMapping(value = "/firstPartReport",method = RequestMethod.POST)
    public void doDownload(HttpServletRequest request,HttpServletResponse response,
    		@RequestBody ParamOnePart paramonepart) throws IOException {
    	
    	 

    	
    	

      
        
        
    }
}
