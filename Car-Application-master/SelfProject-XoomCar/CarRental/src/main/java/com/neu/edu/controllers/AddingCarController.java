package com.neu.edu.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neu.edu.dao.CarDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Car;

@Controller
public class AddingCarController {
	
	@Autowired
	@Qualifier("car")
	private Car car;
	
	@Autowired
	@Qualifier("carDao")
	private CarDAO carDao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = "/addingCar.html", method = RequestMethod.POST)
	public String createCarInventory(HttpServletRequest request, @RequestParam("imageFile") MultipartFile imageFile) throws AdException, IllegalStateException, IOException {
		
		System.out.println("IDHAR bhi AAYA");
		String carName = request.getParameter("UserRegistration[username]");
		String carPrice = request.getParameter("UserRegistration[fname]");
		String vehicleType = request.getParameter("UserRegistration[lname]");
		String vehicleCapacity = request.getParameter("UserRegistration[capacity]");
		String vehicleMilage = request.getParameter("UserRegistration[contactnumber]");
		//long image = Integer.parseInt(request.getParameter("UserRegistration[image]"));

		car.setCarName(carName);
		car.setRent_Price(Float.parseFloat(carPrice));
		car.setCar_Type(vehicleType);
		car.setCar_Capacity(Integer.parseInt(vehicleCapacity));
		car.setCar_Milage(Float.parseFloat(vehicleMilage));
		
		File file;        	
  	  	String check = File.separator;
        String path = null;
        
        if(check.equalsIgnoreCase("\\")) {             
        	path = servletContext.getRealPath("").replace("build\\",""); 
        	path += "resources\\Images\\";
        }

        if(check.equalsIgnoreCase("/")) {
	        path = servletContext.getRealPath("").replace("build/","");
	        path +=  "/resources/Images/"; 
        }
        
        String fileNameWithExt = System.currentTimeMillis() + imageFile.getOriginalFilename();
        file = new File(path+fileNameWithExt);
        String context = servletContext.getContextPath();
        imageFile.transferTo(file);
        String photoFileName = context + "/resources/Images/" +fileNameWithExt;
        car.setCarPhotos(photoFileName);
        car.setPhoto(imageFile);
	
        carDao.createCar(car);
		HttpSession session = request.getSession();
		session.setAttribute("Admin", "Admin");
		return "Dashboard";
	}

	
	
	
}
