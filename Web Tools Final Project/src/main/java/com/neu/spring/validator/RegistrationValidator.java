package com.neu.spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.Customer;


public class RegistrationValidator implements Validator {

	String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	String text_pattern = "^[^<>'\"/;`%]*$";
	
	@Override
	public boolean supports(Class clazz) {
	      
	       return Customer.class.equals(clazz);
	   }


	@Override
	public void validate(Object object, Errors errors) {
		
		
		Pattern emailPattern = Pattern.compile(email_pattern);
		Pattern pattern = Pattern.compile(text_pattern);
		   Matcher matcher;
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.username","Test", "Field cannot be empty");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAccount.password","Test", "Field cannot be empty");

         
         Customer cus=(Customer)object;
         
         matcher = emailPattern.matcher(cus.getEmailID());
         if (!matcher.find()) {
             errors.rejectValue("emailID", "emailID.invalid", new Object[] {cus.getEmailID()}, 
                     "Email ID is not valid.");
         }
         
         if (cus.getMobileNumber().length() != 10) {
             errors.rejectValue("mobileNumber", "mobileNumber.invalid", new Object[] {cus.getMobileNumber()}, 
                     "Please Enter 10 Digit Mobile Number");
         }
         matcher = pattern.matcher(cus.getFirstName());
         if (!matcher.find()){
      	   errors.rejectValue("firstName", "firstName.invalid", new Object[] {cus.getFirstName()}, 
                     "Special characters are not allowed.");
	}
         matcher = pattern.matcher(cus.getLastName());
         if (!matcher.find()){
      	   errors.rejectValue("lastName", "lastName.invalid", new Object[] {cus.getLastName()}, 
                     "Special characters are not allowed.");
         }

         matcher = pattern.matcher(cus.getAge());
         if (!matcher.find()){
      	   errors.rejectValue("age", "age.invalid", new Object[] {cus.getAge()}, 
                     "Special characters are not allowed.");
         }
         matcher = pattern.matcher(cus.getAddress());
         if (!matcher.find()){
      	   errors.rejectValue("address", "address.invalid", new Object[] {cus.getAddress()}, 
                     "Special characters are not allowed.");
         }
	}

}
