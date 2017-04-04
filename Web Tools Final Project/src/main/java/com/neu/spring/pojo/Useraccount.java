package com.neu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="useraccount",uniqueConstraints=@UniqueConstraint(columnNames={"username", "password"}))
public class Useraccount {

	@Id
	@GeneratedValue
	@Column(name="userid", unique=true, nullable=false)
	private int userid;
	
	@Column(name="username",unique=true, nullable=false, length=30)
	private String username;
	
	@Column(name="password", nullable=false, length=30)
	private String password;
	
	@Column(name="role")
	private String role;
	
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="useraccount", fetch=FetchType.EAGER )
//	private Customer customer;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Useraccount(){
		
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}




}
