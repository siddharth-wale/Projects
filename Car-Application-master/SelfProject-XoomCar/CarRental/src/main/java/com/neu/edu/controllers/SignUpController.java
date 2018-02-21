package com.neu.edu.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.constant.Roles;
import com.neu.edu.dao.CustomerDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.UserAccount;
//import com.neu.edu.repository.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	@Qualifier("customer")
	private Customer customer;
	
	@Autowired
	@Qualifier("customerDAO")
	private CustomerDAO customerDao;

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST)
	public String signUpCustomer(HttpServletRequest request) throws AdException {
		
		System.out.println("IDHAR AAYA");
		String firstname = request.getParameter("fs_name");
		String lastName = request.getParameter("ls_name");
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		long phone = Long.parseLong(request.getParameter("contactnum"));

		customer.setAddress(address);
		customer.setFirst_Name(firstname);
		customer.setLast_Name(lastName);
		customer.setEmail(emailId);
		customer.setPhone(phone);
		
		UserAccount userAccount = new UserAccount();
		
		userAccount.setUsername(emailId);
		userAccount.setPassword(password);
		userAccount.setRole("CUSTOMER");
		userAccount.setSocialAccount("MANUAL");
		customer.setUserAccount(userAccount);
		
		userAccount.setCustomer(customer);
		
		customerDao.createCustomer(customer);
		request.setAttribute("Success", "Successfully Created. Please Login!");
		return "home";
	}
}
