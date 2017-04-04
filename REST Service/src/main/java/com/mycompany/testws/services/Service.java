/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testws.services;

import com.mycompany.testws.dao.PersonDao;
import com.mycompany.testws.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
@Path("/service")
public class Service {
    
    //Should simulate a 'database'
    private static Map<Integer,Person> persons = new HashMap<Integer, Person>();
    
//    static {
//        for(int i=0;i<10;i++){
//            Person person = new Person();
//            int id = i+1;
//            person.setId(id);
//            person.setFullName("My Wonderfull Person" + id);
//            person.setAge(new Random().nextInt(40)+1);
//            persons.put(id, person);
//        }
//    }
    
    private PersonDao personDao = new PersonDao();
    
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id){
        return personDao.getPersonByID(id);
    }
    
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id){
       return personDao.getPersonByID(id);
    }
    
    @GET
    @Path("/getAllPersonInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonInXML(){
        return personDao.getAllPersons();
    }
    
}
