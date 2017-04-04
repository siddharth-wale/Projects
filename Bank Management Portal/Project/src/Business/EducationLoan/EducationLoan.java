/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EducationLoan;

import Business.Customer.Customer;

/**
 *
 * @author admin
 */
public class EducationLoan {
     private int loanAmount;
    private int repaymentTerm;
    private String repaymentOption;
    private String universityName;
    private String universityAddress;
    private String courseName;
    private String courseDuration;
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

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityAddress() {
        return universityAddress;
    }

    public void setUniversityAddress(String universityAddress) {
        this.universityAddress = universityAddress;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
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
