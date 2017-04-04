package com.neu.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name="personid")
public class Customer extends Person{

	@Column(name="address")
	private String address;
	

	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="customer", fetch=FetchType.EAGER )
	private Payment payment;
	
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="customer",cascade=CascadeType.ALL)
	private Set<Reservation> reservation = new HashSet<Reservation>();
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="customer", fetch=FetchType.EAGER )
	private Useraccount userAccount;

	
//	@Transient
//	static int count =0;
	
	public Customer(){
		Useraccount ua =new Useraccount();
//		count++;
//		this.setCustomerid(count);	
	}
	
	public Customer(Useraccount ua){
		this.setUserAccount(ua);
		
	}

	public Useraccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Useraccount userAccount) {
		this.userAccount = userAccount;
	}

//	public int getCustomerid() {
//		return customerid;
//	}
//
//
//
//	public void setCustomerid(int customerid) {
//		this.customerid = customerid;
//	}

	




	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
	}



	public Set<Reservation> getReservation() {
		return reservation;
	}



	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}



	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
