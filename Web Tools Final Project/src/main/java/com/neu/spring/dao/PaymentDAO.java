package com.neu.spring.dao;

import org.hibernate.HibernateException;

import com.neu.spring.exception.AdException;
import com.neu.spring.pojo.Payment;

public class PaymentDAO extends DAO{

	public Payment addPayment(Payment payment)throws AdException {
		 try {
	            begin();
//	            System.out.println("inside DAO");
	         
	            getSession().save(payment);
	            
	            commit();
	            return payment;
	        } catch (HibernateException e) {
	            rollback();
	            
	            throw new AdException("Exception while creating reservation: " + e.getMessage());
	        }
	        finally{
	        	close();
	        }
	}
}
