package com.itcoolluck.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itcoolluck.entity.User;
import com.itcoolluck.service.UserService;

@RestController
public class MyRestController {

	    private UserService service;

	    public MyRestController(UserService service) {
	        this.service = service;
	    }

	    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody List<User> getAll() {
	    	System.out.println("Hello World! rest users");
	        return this.service.allUsers();
	    }
	}