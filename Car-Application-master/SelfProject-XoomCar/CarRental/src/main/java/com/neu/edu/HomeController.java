package com.neu.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.CarDAO;
import com.neu.edu.dao.DAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Car;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	@Qualifier("Dao")
	private DAO dao;
	
	@Autowired
	@Qualifier("carDao")
	private CarDAO carDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws AdException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws AdException {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session = request.getSession();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<Car> carList = displayAllCar();
		session.setAttribute("carList", carList);
		session.setAttribute("Admin", "Admin");
		
		return "home";
	}
	
	@RequestMapping(value = "/speech.html", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		
		return "Speech";
	}
	
	public List<Car> displayAllCar() throws AdException {
		List<Car> carList = carDao.getAllCars();
		return carList;
	}
}
