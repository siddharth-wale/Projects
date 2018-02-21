package com.neu.edu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Car")
public class Car {
	
	@Id
	@GeneratedValue
	@Column(name ="car_Id",unique =true,nullable =false)
	private int car_Id;
	
	@Column(name="car_Type")
	private String car_Type; // SUV or Sedan or Hatch
	
	@Column(name="car_Capacity")
	private int car_Capacity; // 7 or 5 or 4
	
	@Column(name="car_Milage")
	private float car_Milage; // 10.0 or 15.0 
	
	@Column(name="car_Classification")
	private String car_Classification; // for-rent or for-selling
	
	@Column(name="rent_Price")
	private float rent_Price;
	
	@Column(name="car_Name")
	private String carName;
	
	@Column(name="selling_Price")
	private float selling_Price;
	
	@Column(name = "PHOTOS", nullable = false, length = 500)
	private String carPhotos;
	
	@Transient
	private MultipartFile photo;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="car", fetch=FetchType.LAZY)
	private Reservation reservation;
	
	public Car() {
		
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	
	public String getCar_Type() {
		return car_Type;
	}
	public void setCar_Type(String car_Type) {
		this.car_Type = car_Type;
	}
	public int getCar_Capacity() {
		return car_Capacity;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void setCar_Capacity(int car_capacity) {
		this.car_Capacity = car_capacity;
	}
	public float getCar_Milage() {
		return car_Milage;
	}
	public void setCar_Milage(float car_milage) {
		this.car_Milage = car_milage;
	}
	public String getCar_Classification() {
		return car_Classification;
	}
	public void setCar_Classification(String car_classification) {
		this.car_Classification = car_classification;
	}
	public float getRent_Price() {
		return rent_Price;
	}
	public void setRent_Price(float rent_price) {
		this.rent_Price = rent_price;
	}
	public float getSelling_Price() {
		return selling_Price;
	}
	public void setSelling_Price(float selling_price) {
		this.selling_Price = selling_price;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getCarPhotos() {
		return carPhotos;
	}

	public void setCarPhotos(String carPhotos) {
		this.carPhotos = carPhotos;
	}
	
	
}
