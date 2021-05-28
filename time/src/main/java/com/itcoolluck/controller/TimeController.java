package com.itcoolluck.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TimeController {
	
	@Value("${download.path}")
	private String dp;
	
    @GetMapping("/time")
    @ResponseStatus(HttpStatus.OK)

    public String getCurrentTime() {
    	
    	SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
		/*
		 * if (authentication != null) { Object principal =
		 * authentication.getPrincipal(); return principal instanceof UserDetails ?
		 * (UserDetails) principal : null; }
		 */
        return Instant.now().toString();
        //return Instant.now().toString()+dp+"!!!";
    }
	
    
 
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/time", method = RequestMethod.POST, produces = "application/json")
    public String getCurrentTime2() {
    	
    	SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
		/*
		 * if (authentication != null) { Object principal =
		 * authentication.getPrincipal(); return principal instanceof UserDetails ?
		 * (UserDetails) principal : null; }
		 */

        return Instant.now().toString()+dp+"!!!";
    }

}
