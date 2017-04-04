package com.neu.spring;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.spring.dao.DAO;
import com.neu.spring.dao.UserAccountDAO;
import com.neu.spring.pojo.Customer;
import com.neu.spring.pojo.Useraccount;
import com.neu.spring.validator.RegistrationValidator;



@Controller
public class CustomerRegisterController {

	@Autowired
	@Qualifier("regValidator")
	private RegistrationValidator registrationValidator;
	
	@Autowired
	@Qualifier("Dao")
	private DAO Dao;
	
	@Autowired
	@Qualifier("userAccountDao")
	private UserAccountDAO userAccountDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(registrationValidator);
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/register.htm")
	public String getRegistrationPage(@ModelAttribute("customer")Customer customer){
		return "registerCustomer";
	}
		@RequestMapping(method=RequestMethod.POST,value="/register.htm")
	    protected String registerUser(@ModelAttribute("customer")Customer customer,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception{
			String action = request.getParameter("action");
			
			registrationValidator.validate(customer, result);
			if(result.hasErrors())
			{
				return "registerCustomer";
			}
			
			
			
			Useraccount ua =customer.getUserAccount();
			ua.setCustomer(customer);
			ua.setRole("customer");
			
			Dao.getSession().beginTransaction();
			Dao.getSession().save(customer);
			Dao.getSession().getTransaction().commit();
			Dao.getSession().close();
			
			request.setAttribute("userCreated","User Created Successfully!!");
		return "registerCustomer";
	}
	
		@RequestMapping(method=RequestMethod.POST,value="/signup.htm")
	    protected String validateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String action = request.getParameter("action");
			
			if (action.equals("ajaxCheck")) {
                PrintWriter out = response.getWriter();
          if(userAccountDao.userExists(request.getParameter("username"))){
              
              JSONObject obj = new JSONObject();
               obj.put("message","Username already exists");
               out.println(obj);
               
           }
          else{
              out.println("Username is available");
          }
          return null;
        }
			return null;
		}
}
