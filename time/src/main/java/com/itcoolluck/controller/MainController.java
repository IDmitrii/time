package com.itcoolluck.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itcoolluck.entity.Customer;
import com.itcoolluck.service.CustomerService;
 
@Controller
public class MainController {
 
	
	
	@RequestMapping("/hello")
	public String easyHello() {
		System.out.println("Hello World! Hello!");	
	   return "hello";
	}
	
	
    @RequestMapping("/")
    public String home() {
      return "index";
     }


		/*
		 * @RequestMapping("/") public ModelAndView home() {
		 * 
		 * ModelAndView mav = new ModelAndView("hello"); // return mav;
		 */     
   
		
	
		         
    }

