package com.itcoolluck.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


	
	@Controller
	public class MyErrorController implements ErrorController {

	    private static final String ERROR_MAPPING = "/error";

	    @RequestMapping(value = ERROR_MAPPING)
	    @ResponseBody
	    public String error() {
	    	System.out.println("Hello World! eRR	jr2!");
	    	
	    	//return "hello";
	    	return "<html><body><h2>Error Page</h2><body></html>";
	    }

	    @Override
	    public String getErrorPath() {
	        return null;
	    }

//    @RequestMapping("/error")
//    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
//    	System.out.println("Hello World!3");	
//        ModelAndView errorPage = new ModelAndView("errorPage");
//        String errorMsg = "";
//        int httpErrorCode = getErrorCode(httpRequest);
//
//        switch (httpErrorCode) {
//            case 400: {
//                errorMsg = "Http Error Code: 400. Bad Request";
//                break;
//            }
//            case 401: {
//                errorMsg = "Http Error Code: 401. Unauthorized";
//                break;
//            }
//            case 404: {
//                errorMsg = "Http Error Code: 404. Resource not found";
//                break;
//            }
//            case 500: {
//                errorMsg = "Http Error Code: 500. Internal Server Error";
//                break;
//            }
//        }
//        errorPage.addObject("errorMsg", errorMsg);
//        return errorPage;
//    }
//    
//    private int getErrorCode(HttpServletRequest httpRequest) {
//        return (Integer) httpRequest
//          .getAttribute("javax.servlet.error.status_code");
//    }
//    
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
}