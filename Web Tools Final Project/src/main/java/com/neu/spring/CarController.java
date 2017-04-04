package com.neu.spring;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.dao.CarDAO;
import com.neu.spring.pojo.Car;
import com.neu.spring.validator.AddCarValidator;

@Controller
public class CarController {
	
	@Autowired
	@Qualifier("addCarValidator")
	private AddCarValidator addCarValidator;
	
	
	@Autowired
	@Qualifier("carDao")
	private CarDAO carDao;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(addCarValidator);
	}
	
	@RequestMapping(value = "/addCarsPage.htm", method = RequestMethod.GET)
	public String getRegistrationPage(@ModelAttribute("car")Car car){
		return "AddCars";
	}
	

	@RequestMapping(value = "/addCar.htm", method = RequestMethod.POST)
	protected String registerUser(@ModelAttribute("car")Car car,BindingResult result,HttpServletRequest request) throws Exception{

		System.out.println("0");
		addCarValidator.validate(car,result);
		if(result.hasErrors())
		{
			return "AddCars";
		}
		

		File file;
        String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
        String path = null;
        if (check.equalsIgnoreCase("\\")) {
            path = request.getSession().getServletContext().getRealPath("").replace("build\\", ""); 
            path += "\\";

        }

        if (check.equalsIgnoreCase("/")) {
            path =request.getSession().getServletContext().getRealPath("").replace("build/", "");
            path += "/"; //Adding trailing slash for Mac systems.


        }

        if (car.getPhoto() != null) {

            String fileNameWithExt = System.currentTimeMillis() + car.getPhoto().getOriginalFilename();
            file = new File("C:\\Users\\Siddharth\\Desktop\\images\\" + fileNameWithExt);

            
            System.out.println(file);
            
            car.getPhoto().transferTo(file);
            car.setPhotoName(fileNameWithExt);

            carDao.addCar(car);
		
	}
        request.setAttribute("carAdded","Car Added Successfully!!");
        return "AddCars";
	}
	
	@RequestMapping(value = "/viewCars.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		List<Car> carList = carDao.getCar();
		ModelAndView mv =new ModelAndView("ViewCars","carList",carList);
		return mv;
	}
	
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequest(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int carid =Integer.parseInt(request.getParameter("id"));
		Car car =carDao.searchCarById(carid);
		
		ModelAndView mv =new ModelAndView("UpdateCar","car",car);
		return mv;
	}
	@RequestMapping(value = "/updateCar.htm", method = RequestMethod.POST)
	protected ModelAndView handle(Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String carName = request.getParameter("carName");
		String carType = request.getParameter("carType");
		int rate = Integer.parseInt(request.getParameter("rate"));
		String transmission = request.getParameter("transmission");
		int id =Integer.parseInt(request.getParameter("id"));
		
		carName=carName.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		carType=carType.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		transmission=transmission.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
		
		carDao.updateCar(carName, carType, rate, transmission, id);

		List<Car> carList = carDao.getCar();
		ModelAndView mv =new ModelAndView("ViewCars","carList",carList);
		return mv;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/searchcar.htm")
    protected String searchCar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String action = request.getParameter("action");
		System.out.println("1");
		if (action.equalsIgnoreCase("searchuser")) {
            List<Car> carList = new ArrayList();
            System.out.println("2");
            String key = request.getParameter("key");
            String searchKey = request.getParameter("flag");
            System.out.println("3");
		carList = carDao.searchCars(key, searchKey);
		System.out.println("4");
        JSONObject obj = new JSONObject();
        obj.put("users",carList);
        PrintWriter out = response.getWriter();
        out.println(obj);
		}
		return null;
	}
		
}


