package com.neu.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity  
@Table(name="admin")  
@PrimaryKeyJoinColumn(name="personid") 
public class Admin extends Person {
	@Column(name="experience")
	private String experience;
	
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="admin")
//	private Set<Car> car = new HashSet<Car>();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="useraccount")
	private Useraccount useraccount;
	
	Admin(){
		
	}

	public Useraccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	public String getExperience() {
		return experience;
	}

//	public Set<Car> getCar() {
//		return car;
//	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
//
//	public void setCar(Set<Car> car) {
//		this.car = car;
//	}
	
	
}
