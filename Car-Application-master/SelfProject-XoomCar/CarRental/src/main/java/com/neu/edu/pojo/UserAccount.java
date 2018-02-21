package com.neu.edu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.neu.edu.constant.Roles;

@Entity
@Table(name="UserAccount")
public class UserAccount {
	
	@Id
	@GeneratedValue
	@Column(name="userId",unique =true,nullable =false)
	private int userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="liscense_No")
	private int liscense_No;
	
	@Column(name="role")
	private String role; //customer or admin
	
	@Column(name = "socialAccount")
	private String socialAccount; //FB MANUAL
	
	@OneToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="customerId", nullable = false,unique =true)
	private Customer customer;
	
	public UserAccount() {
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getLiscense_No() {
		return liscense_No;
	}
	public void setLiscense_No(int liscense_No) {
		this.liscense_No = liscense_No;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSocialAccount() {
		return socialAccount;
	}

	public void setSocialAccount(String socialAccount) {
		this.socialAccount = socialAccount;
	}
	
	
}
