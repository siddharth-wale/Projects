package com.neu.spring;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.PaymentDAO;
import com.neu.spring.dao.ReservationDAO;
import com.neu.spring.pojo.Customer;
import com.neu.spring.pojo.Payment;
import com.neu.spring.pojo.Reservation;
import com.neu.spring.pojo.Useraccount;

@Controller
public class PaymentController {
	
	@Autowired
	@Qualifier("reservationDao")
	private ReservationDAO reservationDao;

	@Autowired
	@Qualifier("paymentDao")
	private PaymentDAO paymentDao;
	
	@RequestMapping(value = "/payment.htm", method = RequestMethod.POST)
	protected ModelAndView handleRequest(Model model ,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Reservation res=(Reservation)session.getAttribute("res");
		Useraccount ua =  (Useraccount) session.getAttribute("username");
		Customer cus = ua.getCustomer();
		
		String cardname = request.getParameter("cardname");					
		String cardnumber = request.getParameter("cardnumber");
		String securitycode = request.getParameter("cvv");
		String expirationmonth = request.getParameter("expirationmonth");
		String expirationyear = request.getParameter("expirationyear");
		String cardtype = request.getParameter("cardtype");
		
		cardname = cardname.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		cardnumber = cardnumber.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		securitycode = securitycode.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		expirationmonth = expirationmonth.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		expirationyear = expirationyear.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		cardtype = cardtype.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		Payment payment = new Payment();
		payment.setCardNumber(cardnumber);
		payment.setCardHolderName(cardname);
		payment.setCvv(securitycode);
		payment.setExpirationMonth(expirationmonth);
		payment.setExpirationYear(expirationyear);
		payment.setCardType(cardtype);
		payment.setBillAmount(res.getCar().getRate());
		payment.setBillDate(String.valueOf(new Date()));
		payment.setCustomer(cus);
		payment.setReservation(res);
		

		res.setCustomer(cus);
		session.setAttribute("res", res);
		reservationDao.addReservation(res);
		paymentDao.addPayment(payment);
		ModelAndView mv= new ModelAndView("CustomerDashboard","paymentSuccess","Payment Successful");
				return mv;
	}
}
