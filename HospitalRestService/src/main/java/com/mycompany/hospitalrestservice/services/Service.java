/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalrestservice.services;

import com.mycompany.hospitalrestservice.dao.SymptomDao;
import com.mycompany.hospitalrestservice.model.Disease;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
@Path("/service")
public class Service {

    private SymptomDao symptomDao = new SymptomDao();
   
    
    @GET
    @Path("/getAllDiseaseInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Disease> getAllDiseaseInXML(){
        return symptomDao.getDiseaseList();
    }
    
    @GET
    @Path("/getAllDiseaseInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disease> getAllDiseaseInJSON(){
        return symptomDao.getDiseaseList();
    }
    
}