package com.neu.spring.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.exception.AdException;
import com.neu.spring.pojo.Useraccount;


public class UserAccountDAO extends DAO{


    
	public UserAccountDAO(){
		
	}
	public Useraccount loginUser(String username,String password) throws AdException{
		 try {
	            begin();
	            Query query = (Query)getSession().createQuery("from Useraccount where username = :username and password = :password");
	            query.setString("username",username);
	            query.setString("password", password);
	            Useraccount useraccount=(Useraccount) query.uniqueResult();
	            System.out.println(useraccount);
	            return useraccount;
	}catch (HibernateException e) {
        rollback();
        throw new AdException("Could not get user " + e);
    }
    finally {
		close();
	}
}
	
    public boolean userExists(String username)  throws AdException{
        
    try {
    	 begin();
         Query query = getSession().createQuery("from Useraccount where username = :username");
         query.setString("username",username);
        
         Useraccount useraccount=(Useraccount) query.uniqueResult();

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
