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
public class CustomerController {
 
	  @Autowired
	  private CustomerService customerService;
	
	  
	  @GetMapping("/customer_list")
	  public String userList(Model model) {
		  List<Customer> listCustomer = customerService.listAll(); 
	        model.addAttribute("listCustomer", listCustomer);
	        return "customer_list";
	    }
	
		/*
		 * @RequestMapping("/customer_list") public ModelAndView home() { List<Customer>
		 * listCustomer = customerService.listAll(); ModelAndView mav = new
		 * ModelAndView("customer_list"); mav.addObject("listCustomer", listCustomer);
		 * return mav; }
		 */
	
	
	
	
	
	  @RequestMapping("/new") public String newCustomerForm(Map<String, Object>
	  model) { Customer customer = new Customer(); model.put("customer", customer);
	  return "new_customer"; }
	 	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
	    customerService.save(customer);
	    return "redirect:/customer_list";
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Customer customer = customerService.get(id);
	    mav.addObject("customer", customer);
	 
	    return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    customerService.delete(id);
	    return "redirect:/";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
	}

 
		
		/*
		 * List<Customer> listCustomer = customerService.listAll(); ModelAndView mav =
		 * new ModelAndView("index"); mav.addObject("listCustomer", listCustomer);
		 * return mav;
		 */
		         
    }

