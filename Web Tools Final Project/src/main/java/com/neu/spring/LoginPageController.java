package com.neu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginPageController {
	@RequestMapping(value = "/loginPage.htm", method = RequestMethod.GET)
	public String showLoginPage(){
		return "Login";
	}
	
	@RequestMapping(value = "/reservationPage.htm", method = RequestMethod.GET)
	public String showReservationPage(){
		return "carReservation";
	}
	
	
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping(value = "/adminHome.htm", method = RequestMethod.GET)
	public String showAdminHomePage(){
		return "AdminDashboard";
	}
	
	@RequestMapping(value = "/customerHome.htm", method = RequestMethod.GET)
	public String showCustomerHomePage(){
		return "CustomerDashboard";
	}
	
	@RequestMapping(value = "/email.htm", method = RequestMethod.GET)
	public String sendMail(){
		return "emailClient";
	}
	
	@RequestMapping(value = "/viewOrder.htm", method = RequestMethod.GET)
	public String myOrder(){
		return "ViewOrder";
	}
	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String searchCar(){
		return "searchCars";
	}


}
