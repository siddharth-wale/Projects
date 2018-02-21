package com.neu.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RentalController {
	
	@RequestMapping(value="/signup.html", method =RequestMethod.GET)
	public String returnSignUp() {
		return "SignUp";
	}	

	
	
}
