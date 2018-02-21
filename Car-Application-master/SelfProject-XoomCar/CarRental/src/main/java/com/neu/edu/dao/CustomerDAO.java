package com.neu.edu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Customer;
import com.neu.edu.pojo.UserAccount;


public class CustomerDAO extends DAO {

	public CustomerDAO() {
		
	}
	
	public Customer createCustomer(Customer customer) throws AdException {
		try {
			begin();
			getSession().save(customer);
			commit();
			return customer;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating Customer: " + e.getMessage());
		}
		finally {
			close();
		}
	}
	
	public UserAccount useraccount(String username, String password) throws AdException {
		try {
			begin();
			Query query = (Query) getSession().createQuery("from UserAccount where username = :username and password= :password");
			query.setString("username", username);
			query.setString("password", password);
			UserAccount useraccount = (UserAccount)query.uniqueResult();
			return useraccount;
		} catch(HibernateException e) { 
			rollback();
			throw new AdException("Exception while login: " + e.getMessage());
		} finally {
			close();
		}		
	}
	
    public boolean userExists(String username)  throws AdException{
         try {
    	 begin();
         Query query = getSession().createQuery("from UserAccount where username = :username");
         query.setString("username",username);
        
         UserAccount useraccount=(UserAccount) query.uniqueResult();

         commit();
          if(useraccount!=null){
        	  return true;
          }
          else{
        	  return false;
          }
    }catch (HibernateException e) {
        rollback();
       return false;
        
       
    }
    finally {
		close();
	}
   
}
}
