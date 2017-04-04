package com.neu.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/3users.htm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		try
		{
			String line;
		//	System.out.println("---------------");
			Process p = Runtime.getRuntime().exec("python C://Users//Maansi//Documents//workspace-sts-3.7.3.RELEASE//Simulate_Python//src//main//MyDB//MyDBTest.py");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));


			while ((line = input.readLine()) != null) {
			System.out.println(line);
			
			}
			  

		
		
		
		
		
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			//return "home";
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "home";
	}	
	
	@RequestMapping(value = "/10users.htm", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		try
		{
			String line;
		//	System.out.println("---------------");
			Process p = Runtime.getRuntime().exec("python C://Users//Maansi//Documents//workspace-sts-3.7.3.RELEASE//Simulate_Python//src//main//MyDB//MyDBTest2.py");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));


			while ((line = input.readLine()) != null) {
			System.out.println(line);
			
			}
			  

		
		
		
		
		
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			//return "home";
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "home";
	}	
	
	
	@RequestMapping(value = "/17users.htm", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		try
		{
			String line;
		//	System.out.println("---------------");
			Process p = Runtime.getRuntime().exec("python C://Users//Maansi//Documents//workspace-sts-3.7.3.RELEASE//Simulate_Python//src//main//MyDB//MyDBTest3.py");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));


			while ((line = input.readLine()) != null) {
			System.out.println(line);
			
			}
			  

		
		
		
		
		
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			//return "home";
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "home";
	}	
	
	@RequestMapping(value = "/24users.htm", method = RequestMethod.GET)
	public String home3(Locale locale, Model model) {
		try
		{
			String line;
		//	System.out.println("---------------");
			Process p = Runtime.getRuntime().exec("python C://Users//Maansi//Documents//workspace-sts-3.7.3.RELEASE//Simulate_Python//src//main//MyDB//MyDBTest4.py");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));


			while ((line = input.readLine()) != null) {
			System.out.println(line);
			
			}
			  

		
		
		
		
		
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			//return "home";
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "home";
	}	
	
	
}
