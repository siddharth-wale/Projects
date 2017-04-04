package com.neu.spring;

import java.util.ArrayList;
import java.util.List;

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

import com.neu.spring.dao.CarDAO;
import com.neu.spring.dao.UserAccountDAO;
import com.neu.spring.pojo.Car;
import com.neu.spring.pojo.Reservation;
import com.neu.spring.pojo.Useraccount;

@Controller
public class ReservationController {
	
	@Autowired
	@Qualifier("carDao")
	private CarDAO carDao;

	@RequestMapping(value = "/addreservation.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String location   = request.getParameter("location");
		String pickDate   = request.getParameter("pickDate");
		String pickTime   = request.getParameter("pickTime");
		String returnDate = request.getParameter("returnDate");
		String returnTime = request.getParameter("returnTime");
		
		location = location.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		pickDate = pickDate.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		pickTime = pickTime.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		returnDate = returnDate.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		returnTime = returnTime.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();

		
		Reservation res = new Reservation();
		res.setPickUpLocation(location);
		res.setPickUpDate(pickDate);
		res.setPickUpTime(pickTime);
		res.setReturnDate(returnDate);
		res.setReturnTime(returnTime);
		
		HttpSession session = request.getSession();
		session.setAttribute("res", res);
		
		List<Car> carList = carDao.getCar();
		ModelAndView mv =new ModelAndView("cusViewCar","carList",carList);
		return mv;
	}
	
	@RequestMapping(value = "/cusviewcar.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequest(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{

		int carid =Integer.parseInt(request.getParameter("id"));
		Car car =carDao.searchCarById(carid);
		System.out.println(car.getCarName());
		ModelAndView mv =new ModelAndView("cusSelectCar","car",car);
		return mv;
	
	}
	
	@RequestMapping(value = "/selectCar.htm", method = RequestMethod.POST)
	protected ModelAndView handleRequest1(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String action = request.getParameter("action");
		String carName = request.getParameter("carName");
		String carType = request.getParameter("carType");
		int rate = Integer.parseInt(request.getParameter("rate"));
		String transmission = request.getParameter("transmission");
		int id =Integer.parseInt(request.getParameter("id"));
       
		carName = carName.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		carType = carType.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		transmission = transmission.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		Car car = new Car();
		car.setId(id);
		car.setCarName(carName);
		car.setCarType(carType);
		car.setRate(rate);
		car.setTransmission(transmission);
		
		HttpSession session = request.getSession();
		Reservation res=(Reservation)session.getAttribute("res");

		res.setCar(car);
		session.setAttribute("res", res);

		if(action.equalsIgnoreCase("checkout")){
			if (session.getAttribute("username") != null) {	
				ModelAndView mv =new ModelAndView("paymentCard","res",res);
				return mv;
			}

		}
		ModelAndView mv =new ModelAndView("Login","res",res);
		return mv;
		
	}
	
	@RequestMapping(value = "/selectCarOrderPage.htm", method = RequestMethod.POST)
	protected ModelAndView handleRequest2(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		Reservation res=(Reservation)session.getAttribute("res");
		ModelAndView mv =new ModelAndView("paymentCard","res",res);
		return mv;
	}

}

