/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hospitalrestservice.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author admin
 */
@Entity
@Table(name="DISEASE")
@XmlRootElement(name="disease")
@XmlType(propOrder={"id", "name", "diseaseSymp", "details"})
public class Disease {

    public Disease(){
        
    }
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="diseasesymp")
    private String diseaseSymp;
    
    @Column(name = "details")
    private String details;
    

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlElement
    public String getDiseaseSymp() {
        return diseaseSymp;
    }

    public void setDiseaseSymp(String diseaseSymp) {
        this.diseaseSymp = diseaseSymp;
    }

    @XmlElement
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}