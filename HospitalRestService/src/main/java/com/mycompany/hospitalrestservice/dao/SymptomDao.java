/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalrestservice.dao;

import com.mycompany.hospitalrestservice.model.Disease;
import com.mycompany.hospitalrestservice.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class SymptomDao {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public List<Disease> getDiseaseList(){
       List<Disease> diseases = null;
       Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            diseases= session.createQuery("from Disease d").list();
            session.getTransaction().commit();
        }catch(Exception ex){
            if(session!=null){
                session.getTransaction().rollback();
            }
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return diseases;
    }
    
}