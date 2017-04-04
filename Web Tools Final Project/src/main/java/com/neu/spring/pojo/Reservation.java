package com.neu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name="reservationid", unique = true, nullable = false)
	private int reservationID;
	
	@Column(name="pick_up_location")
	private String pickUpLocation;
	
	@Column(name="pick_up_date")
	private String pickUpDate;
	
	@Column(name="pick_up_time")
	private String pickUpTime;
	
	@Column(name="return_date")
	private String returnDate;
	
	@Column(name="return_time")
	private String returnTime;
	
	
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="customer",nullable = false)
	private Customer customer;
    

    
    @ManyToOne(fetch=FetchType.EAGER)
 	@JoinColumn(name="carid",nullable = false)
 	private Car car;
    
	@OneToOne(cascade=CascadeType.ALL,mappedBy="reservation", fetch=FetchType.LAZY )
	private Payment payment;
	
	public Reservation(){
		
	}
	
	
	public String getPickUpTime() {
		return pickUpTime;
	}


	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}


	public String getReturnTime() {
		return returnTime;
	}


	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}



	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public String getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
