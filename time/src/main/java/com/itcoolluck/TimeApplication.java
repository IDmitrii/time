package com.itcoolluck;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class TimeApplication {
	
	@Value("${download.path}")
	private static String d2;

	public static void main(String[] args) {
	
		SpringApplication.run(TimeApplication.class, args);
		
		System.out.println("Hello World!");	
		System.out.println(d2);	
	}
	
	
	
	
	}

	/*
	 * //ServletInitializer.java public class ServletInitializer extends
	 * SpringBootServletInitializer {
	 * 
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(SpringBootApplication.class); }
	 */