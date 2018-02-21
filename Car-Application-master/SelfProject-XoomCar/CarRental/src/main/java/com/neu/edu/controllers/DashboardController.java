package com.neu.edu.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.pojo.Car;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.Reservation;
import com.neu.edu.pojo.UserAccount;

@Controller
public class DashboardController {

	@Autowired
	@Qualifier("reservation")
	private Reservation reservation;
	
	
	
	@RequestMapping(value="/dashboard.html", method =RequestMethod.POST)
	public String returnDashboard(HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession();
		UserAccount useraccount = (UserAccount) session.getAttribute("useraccount");
		
		
//		System.out.print("rerere"+ session.getAttribute("Customer"));
		 
		if(useraccount != null) {
			Customer customer = useraccount.getCustomer();
			String pickuplocation = request.getParameter("pickuplocation");
			String dropPoint = request.getParameter("dropPoint");
			String inDate = request.getParameter("in-date");
			String outDate = request.getParameter("out-date");
			
			reservation.setCustomer(customer);
			reservation.setPickUpLocation(pickuplocation);
			reservation.setPickUpDate(inDate);
			reservation.setReturnDate(outDate);
			
			
			
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");  
			Date date1 = formatter1.parse(inDate);
			
			SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");  
			Date date2 = formatter2.parse(outDate); 
			
			int diff = date2.getDate() - date1.getDate();
			
			
			session.setAttribute("reservation", reservation);
			session.setAttribute("noOfDays", diff);
			session.setAttribute("startDate", inDate);
			session.setAttribute("endDate", outDate);
			return "Dashboard";
		}
		else {
			request.setAttribute("ERROR", "Please log into your account first!!!");
			return "home";
		}
	}
	
	
	
	@RequestMapping(value="/addcar.html", method =RequestMethod.GET)
	public String returnAddCar() {
		return "AddingCar";
	}
	@RequestMapping(value="/adminDashboard.htm", method =RequestMethod.GET)
	public String returnAdminDashboard() {
		return "Dashboard";
	}
	
	@RequestMapping(value="/userDashboard.htm", method =RequestMethod.GET)
	public String returnUserDashboard() {
		return "UserLogin";
	}
	
	@RequestMapping(value="/OuterDashboard.html", method = RequestMethod.POST)
	public String carSearch(HttpServletRequest request) {
		String inputText = request.getParameter("inputText");
		System.out.println(inputText);
		HttpSession session = request.getSession();
		session.setAttribute("inputText", inputText);
		return "OuterDashboard";
	}
}
