package com.neu.edu.dao;

import org.hibernate.HibernateException;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Reservation;

public class ReservationDao extends DAO{

public ReservationDao(){
		
	}
	
	public Reservation addReservation(Reservation res)throws AdException {
		try {
			begin();
			getSession().save(res);
			commit();
			return res;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating Reservation: " + e.getMessage());
		}
		finally {
			close();
		}
	}
}
