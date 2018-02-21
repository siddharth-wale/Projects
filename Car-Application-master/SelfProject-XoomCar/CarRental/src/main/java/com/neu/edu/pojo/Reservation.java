package com.neu.edu.pojo;

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

import com.neu.edu.pojo.Payment;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Id
	@GeneratedValue
	@Column(name="reservationId",unique =true,nullable =false)
	private int reservationId;
	
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
	
	@Column(name="dropLocation")
	private String dropLocation;
	
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	@Column(name="dropPoint")
	private String dropPoint;
	
	@OneToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="carId", unique =true)
	private Car car;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="reservation", fetch=FetchType.LAZY )
	private Payment payment;
	
	public Reservation() {
		
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
}
