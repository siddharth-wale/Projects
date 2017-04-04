package com.neu.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.exception.AdException;
import com.neu.spring.pojo.Car;


public class CarDAO extends DAO{
	
	public CarDAO(){
		
	}
	public Car addCar(Car c) throws AdException {
		 try {
	            begin();
//	            System.out.println("inside DAO");
	         
	            getSession().save(c);
	            
	            commit();
	            return c;
	        } catch (HibernateException e) {
	            rollback();
	            
	            throw new AdException("Exception while creating car: " + e.getMessage());
	        }
	        finally{
	        	close();
	        }
	}
	
	public List<Car> getCar() throws AdException{
		
		try {
		     begin();
		     Criteria crit=getSession().createCriteria(Car.class);
		     List<Car> carList=crit.list();
		     commit();
		     return carList;

		 } catch (HibernateException e) {
		     rollback();
		     throw new AdException("Could not get user " +  e);
		 }
		
	}
	
	public Car searchCar(String carName) throws AdException{
		
		try {
			  begin();
		      Query q = getSession().createQuery("from Car where carName = :carName");
		      q.setString("carName", carName);
		      Car car =(Car) q.uniqueResult();
		      commit();
		      return car;
		}
	 catch (HibernateException e) {
	      rollback();
	      throw new AdException("Could not get user " + carName, e);
	  }
	
}
	public Car searchCarById(int id) throws AdException{
		
		try {
			  begin();
		      Query q = getSession().createQuery("from Car where id = :id");
		      q.setParameter("id", id);
		      Car car =(Car) q.uniqueResult();
		      commit();
		      return car;
		}
	 catch (HibernateException e) {
	      rollback();
	      throw new AdException("Could not get user " + id, e);
	  }
	
}
	
	public void updateCar(String carName,String carType,int rate,
			String transmission,int id)throws AdException{
		try{
			begin();

			 Query q = getSession().createQuery("Update Car set carName = :carName, "
			 		+ " carType = :carType, rate = :rate,  transmission = :transmission "
			 		+ "WHERE id = :id");
			 q.setString("carName", carName);
			 q.setString("carType", carType);
			 q.setInteger("rate", rate);
			 q.setString("transmission",transmission );
			 q.setInteger("id", id);
			 q.executeUpdate();

			 commit();
		}
		catch (HibernateException e) {
		      rollback();
		      throw new AdException("Could not get user " + carName, e);
		  }
	}
	
	
    public List<Car> searchCars(String key, String flag) {
       
        Query query = null;
        List<Car> list = new ArrayList<Car>();
        try {
        	System.out.println("1");
            String hql = "FROM Car c where c." + flag + "= :value";
            System.out.println("1");
            query = getSession().createQuery(hql);
            query.setParameter("value", key);
            list = query.list();
            System.out.println("1");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }

}
