package com.neu.edu.dao;

import org.hibernate.HibernateException;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Payment;

public class PaymentDao extends DAO {
	
	public PaymentDao() {
		
	}
	public Payment addPayment(Payment payment)throws AdException {
		try {
			begin();
			getSession().save(payment);
			commit();
			return payment;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating Payment: " + e.getMessage());
		}
		finally {
			close();
		}
	}
}
