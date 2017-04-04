package com.neu.spring;

import java.util.ArrayList;

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

import com.neu.spring.dao.UserAccountDAO;
import com.neu.spring.pojo.Reservation;
import com.neu.spring.pojo.Useraccount;

@Controller
public class LoginController  {
	
	@Autowired
	@Qualifier("userAccountDao")
	private UserAccountDAO userAccountDao;
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	
	protected ModelAndView handleRequestInternal(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		HttpSession session= request.getSession();
		
		
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		System.out.println(userAccountDao);
		Useraccount ua = userAccountDao.loginUser(username, password);
		 session.setAttribute("username", ua);
		 session.setAttribute("token", "yes");
		 if(ua!=null){
		if(ua.getRole().equalsIgnoreCase("customer")){
			System.out.println("2");
			ModelAndView mv= new ModelAndView("CustomerDashboard","username",ua);
			return mv;
		}
		else if(ua.getRole().equalsIgnoreCase("admin")){
			System.out.println("3");
			ModelAndView mv = new ModelAndView("AdminDashboard","username",ua);
			return mv;
		}
		 
		 }else{
			System.out.println("4");
			ModelAndView mv = new ModelAndView("Login","error","UserName or Password Invalid");
			return mv;
		}
		 return null;
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		request.getSession().removeAttribute("res");
		request.getSession().removeAttribute("token");
		
		return "home";
	}
	
}
