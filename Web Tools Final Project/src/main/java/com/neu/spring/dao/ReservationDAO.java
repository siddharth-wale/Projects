package com.neu.spring.dao;

import org.hibernate.HibernateException;

import com.neu.spring.exception.AdException;
import com.neu.spring.pojo.Reservation;

public class ReservationDAO extends DAO{

	public ReservationDAO(){
		
	}
	
	public Reservation addReservation(Reservation res)throws AdException {
		 try {
	            begin();
//	            System.out.println("inside DAO");
	         
	            getSession().save(res);
	            
	            commit();
	            return res;
	        } catch (HibernateException e) {
	            rollback();
	            
	            throw new AdException("Exception while creating reservation: " + e.getMessage());
	        }
	        finally{
	        	close();
	        }
	}
}
