package com.neu.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int paymentID;
	
	@Column(name="card_holder_name")
	private String cardHolderName;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="cvv")
	private String cvv;
	
	@Column(name="expiration_month")
	private String expirationMonth;
	
	@Column(name="expiration_year")
	private String expirationYear;
	
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="customer",nullable = false) 
	private Customer customer;
	
	@Column(name="bill_amount")
	private int billAmount;
	
	@Column(name="bill_date")
	private String billDate;
	
	@Column(name="cardType")
	private String cardType;
	
	
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="reservation",nullable = false) 
	private Reservation reservation;

	public Payment(){
		
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public String getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
