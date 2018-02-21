package com.neu.edu.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.pojo.Car;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.Payment;
import com.neu.edu.pojo.Reservation;
import com.neu.edu.pojo.UserAccount;
import com.neu.edu.dao.PaymentDao;
import com.neu.edu.dao.ReservationDao;

@Controller
public class PaymentController {
	
	@Autowired
	@Qualifier("payment")
	private Payment payment;
	
	@Autowired
	@Qualifier("reservationDao")
	private ReservationDao reservationDao;
	
	@Autowired
	@Qualifier("paymentDao")
	private PaymentDao paymentDao;
	
	@RequestMapping(value="/payment.html", method =RequestMethod.GET)
	public String returnPayment() {
		return "Payment";
	}
	
	@RequestMapping(value="/payment.html", method = RequestMethod.POST)
	public String carPayment(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Car carPay = (Car) session.getAttribute("carPay");
		Reservation res = (Reservation) session.getAttribute("reservation");
		UserAccount ua = (UserAccount) session.getAttribute("useraccount");
		Customer cus = ua.getCustomer();
		
		String cardNumber = request.getParameter("cardNumber");
		String expDate = request.getParameter("cardExpiry");
		String cvv = request.getParameter("cardCVV");
		String cardHolderName = request.getParameter("cardHolderName");
		
		payment.setCardHolderName(cardHolderName);
		payment.setCardNumber(cardNumber);
		payment.setExpirationMonth(expDate);
		payment.setCvv(cvv);
		payment.setBillAmount(2367F);
		payment.setBillDate(String.valueOf(new Date()));
		payment.setCustomer(cus);
		payment.setReservation(res);
		paymentDao.addPayment(payment);
		
//		carPay.setReservation(res);
	
		res.setCar(carPay);
		res.setCustomer(cus);
		
		reservationDao.addReservation(res);
	
		
		session.setAttribute("paymentmsg", "Payment was successfull");
		
		return "home";
	}
	
	@RequestMapping(value="/carPayment.htm", method = RequestMethod.POST)
	public String carPaymentDetails(HttpServletRequest request) {
		String carNamePay = request.getParameter("carNamePay");
		String carRentPricePay = request.getParameter("carRentPricePay");
		String carCapacityPay = request.getParameter("carCapacityPay");
		String carMilagePay = request.getParameter("carMilagePay");
		String carTypePay = request.getParameter("carTypePay");
		
		Car car = new Car();
		car.setCarName(carNamePay);
		car.setRent_Price(Float.parseFloat(carRentPricePay));
		car.setCar_Capacity(Integer.parseInt(carCapacityPay));
		car.setCar_Milage(Float.parseFloat(carMilagePay));
		car.setCar_Type(carTypePay);
		
		HttpSession session = request.getSession();
		session.setAttribute("carPay", car);
		
		return "Payment";
	}
	
}
