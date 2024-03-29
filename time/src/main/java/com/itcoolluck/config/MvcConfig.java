package com.itcoolluck.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

   
	
	  public void addViewControllers(ViewControllerRegistry registry) {
	  registry.addViewController("/login").setViewName("login");
	  registry.addViewController("/news").setViewName("news"); 
	  registry.addViewController("/").setViewName("welcome"); 
	  
	  
	  }
	  @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
		
		
	}	
	 
}	