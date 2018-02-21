package com.neu.edu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.pojo.Reservation;


@Controller
public class ReservationController {
	
	@Autowired
	@Qualifier("reservation")
	private Reservation reservation;
	
	@RequestMapping(value="/reservation.html", method =RequestMethod.GET)
	public String returnReservation() {
		
		return "Reservation";
	}	
	
	@RequestMapping(value="/reservation.html", method =RequestMethod.POST)
	public String setReseration(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String pickLocation = request.getParameter("pickupLocation");
		String dropPoint = request.getParameter("dropPoint");
		String dropLocation = request.getParameter("dropLocation");
		String pickDate   = request.getParameter("in-date");
		String returnDate = request.getParameter("out-date");
		
		System.out.println(pickLocation + " " + dropLocation + " " + dropPoint + " " + pickDate + " " + returnDate);
		
		reservation.setPickUpDate(pickDate);
		reservation.setReturnDate(returnDate);
		reservation.setPickUpLocation(pickLocation);
		reservation.setDropPoint(dropPoint);
		reservation.setDropLocation(dropLocation);
		
		session.setAttribute("reservation", reservation);
		return "CustomerDashboard";
	}
	

}
