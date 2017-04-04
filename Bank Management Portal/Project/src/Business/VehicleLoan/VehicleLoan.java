/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VehicleLoan;

import Business.Customer.Customer;

/**
 *
 * @author admin
 */
public class VehicleLoan {
    private String vehiccleCondition;
    private int loanAmount;
    private int repaymentTerm;
    private String repaymentOption;
    private String vehicleType;
    private String brand;
    private String model;
    private double rateOfInterest;
    private String currentEmployerName;
    private String occupation;
    private int annualGrossIncome;
    private String anyOtherLoan;
    private Customer customer;
    private String status;
       private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getVehiccleCondition() {
        return vehiccleCondition;
    }

    public void setVehiccleCondition(String vehiccleCondition) {
        this.vehiccleCondition = vehiccleCondition;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

   

    public int getRepaymentTerm() {
        return repaymentTerm;
    }

    public void setRepaymentTerm(int repaymentTerm) {
        this.repaymentTerm = repaymentTerm;
    }

    public String getRepaymentOption() {
        return repaymentOption;
    }

    public void setRepaymentOption(String repaymentOption) {
        this.repaymentOption = repaymentOption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getCurrentEmployerName() {
        return currentEmployerName;
    }

    public void setCurrentEmployerName(String currentEmployerName) {
        this.currentEmployerName = currentEmployerName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAnnualGrossIncome() {
        return annualGrossIncome;
    }

    public void setAnnualGrossIncome(int annualGrossIncome) {
        this.annualGrossIncome = annualGrossIncome;
    }

    public String getAnyOtherLoan() {
        return anyOtherLoan;
    }

    public void setAnyOtherLoan(String anyOtherLoan) {
        this.anyOtherLoan = anyOtherLoan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
       @Override
    public String toString() {
        return this.date;
    }
}
