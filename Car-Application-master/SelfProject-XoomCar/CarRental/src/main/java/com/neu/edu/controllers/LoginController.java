package com.neu.edu.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.neu.edu.dao.CarDAO;
import com.neu.edu.dao.CustomerDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Car;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.UserAccount;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("customer")
	private Customer customer;
	
	@Autowired
	@Qualifier("userAccount")
	private UserAccount userAccount;
	
	@Autowired
	@Qualifier("carDao")
	private CarDAO carDao;
	
	@Autowired
	@Qualifier("customerDAO")
	private CustomerDAO customerDAO;
	
	@RequestMapping(value="/userLogin.html", method = RequestMethod.POST)
	public String returnUserLogin(HttpServletRequest request) throws AdException {
		HttpSession session = request.getSession();

		String username = request.getParameter("email");
		String password = request.getParameter("password");

		UserAccount useraccount = customerDAO.useraccount(username, password);
		if(useraccount == null) {
			request.setAttribute("ERROR", "Invalid username and password");
			System.out.println("login1");
			return "home";
		}
		if(useraccount != null) {
			session.setAttribute("useraccount", useraccount);
			String userFirstName = useraccount.getCustomer().getFirst_Name();
			session.setAttribute("userFirstName", userFirstName);
			if(useraccount.getRole().equals("CUSTOMER")) {
				List<Car> carList = displayAllCar();
				session.setAttribute("carList", carList);
				session.setAttribute("Customer", "Customer");
				return "UserLogin";
			}
			else {
				AddingCarController addingCarController = new AddingCarController();
				List<Car> carList = displayAllCar();
				session.setAttribute("carList", carList);
				session.setAttribute("Admin", "Admin");
				return "Dashboard";
			}
			
		}
			return "home";
		
	}
	
	@RequestMapping(value="/logout.html", method =RequestMethod.GET)
	public String returnHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("useraccount");
		session.removeAttribute("userFirstName");
		session.invalidate();
		return "home";
	}
	
	public List<Car> displayAllCar() throws AdException {
		List<Car> carList = carDao.getAllCars();
		return carList;
	}
	@RequestMapping(value="/fblogincontroller.htm", method =RequestMethod.GET)
	public String returnfbLoginController(HttpServletRequest request) throws AdException  {
		HttpSession session = request.getSession();
		String firstname=request.getParameter("user_name");
		String emailId=request.getParameter("user_email");
//		String password=request.getParameter("user_password");
		System.out.println(customerDAO.userExists(emailId));
		if(customerDAO.userExists(emailId)) {
			System.out.println(customerDAO.userExists(emailId));
			session.setAttribute("userFirstName", firstname);
			return "UserLogin";
		}else {
		customer.setFirst_Name(firstname);
		customer.setEmail(emailId);
		userAccount.setUsername(emailId);
		userAccount.setRole("CUSTOMER");
//		userAccount.setPassword(password);
		customer.setUserAccount(userAccount);
		userAccount.setCustomer(customer);
		customerDAO.createCustomer(customer);
		session.setAttribute("userFirstName", firstname);
		return "UserLogin";
		}
	}
}


