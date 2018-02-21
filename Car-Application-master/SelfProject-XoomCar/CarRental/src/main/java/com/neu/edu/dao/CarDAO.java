package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Car;

public class CarDAO extends DAO{

	public CarDAO() {
		
	}
	
	public Car createCar(Car car) throws AdException {
		try {
			begin();
			getSession().save(car);
			commit();
			return car;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating Car: " + e.getMessage());
		}
		finally {
			close();
		}
	}
	
	public List<Car> getAllCars() throws AdException {
		try {
			begin();
			Criteria crit = getSession().createCriteria(Car.class);
			List<Car> carList = crit.list();
			return carList;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while fetching Car: " + e.getMessage());
		}
		finally {
			close();
		}
	}
}
