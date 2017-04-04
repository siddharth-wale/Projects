package com.neu.spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.neu.spring.pojo.Car;

public class AddCarValidator implements Validator{

	 private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Car.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		
        
        Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
        
        
        ValidationUtils.rejectIfEmpty(errors, "carName","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "carType","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "rate","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "transmission","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "photo","Test", "Field cannot be empty");
		
        Car car= (Car) object;
        photo=car.getPhoto();
        
    	matcher = pattern.matcher(photo.getOriginalFilename());
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","Test","File is empty");
        }
              if(!matcher.matches()) {
             errors.rejectValue("photo","Test","Invalid Image Format");
        }
        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","Test","File size is over 5mb !");
        }
        
  
      
        
       
        
    
	}
	 
}
