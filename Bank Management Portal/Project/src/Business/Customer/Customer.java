/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.CommercialLoan.CommercialLoanDirectory;
import Business.EducationLoan.EducationLoanDirectory;
import Business.Enterprise.Enterprise;
import Business.HouseLoan.HouseLoanDirectory;
import Business.Person.Person;
import Business.Transaction.TransactionDirectory;
import Business.VehicleLoan.VehicleLoanDirectory;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Customer {
    
    private Person person;
    private int accountNumber;
    private int routingNumber;
    private String swiftCode;
    private String branchName;
    private int balance;
    private String name;
    private Date dateOfBirth;
    private String address;
    private int mobileNumber;
    private int ssnNumber;
    private static int count= 903938334;
    private String emailAddress;
    private Enterprise enterprise;
   
       private VehicleLoanDirectory vehicleLoanDirectory;
    private HouseLoanDirectory houseLoanDirectory;
    private CommercialLoanDirectory commercialLoanDirectory;
    private EducationLoanDirectory educationLoanDirectory;
    private TransactionDirectory transactionDirectory;
    
    public Customer(){
        accountNumber=count++;
         vehicleLoanDirectory=new VehicleLoanDirectory();
       
        houseLoanDirectory =new HouseLoanDirectory();
        commercialLoanDirectory= new CommercialLoanDirectory();
        educationLoanDirectory= new EducationLoanDirectory();
        transactionDirectory= new TransactionDirectory();
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

   

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

  

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getSsnNumber() {
        return ssnNumber;
    }

    public void setSsnNumber(int ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public VehicleLoanDirectory getVehicleLoanDirectory() {
        return vehicleLoanDirectory;
    }

    public void setVehicleLoanDirectory(VehicleLoanDirectory vehicleLoanDirectory) {
        this.vehicleLoanDirectory = vehicleLoanDirectory;
    }

    public HouseLoanDirectory getHouseLoanDirectory() {
        return houseLoanDirectory;
    }

    public void setHouseLoanDirectory(HouseLoanDirectory houseLoanDirectory) {
        this.houseLoanDirectory = houseLoanDirectory;
    }

    public CommercialLoanDirectory getCommercialLoanDirectory() {
        return commercialLoanDirectory;
    }

    public void setCommercialLoanDirectory(CommercialLoanDirectory commercialLoanDirectory) {
        this.commercialLoanDirectory = commercialLoanDirectory;
    }

    public EducationLoanDirectory getEducationLoanDirectory() {
        return educationLoanDirectory;
    }

    public void setEducationLoanDirectory(EducationLoanDirectory educationLoanDirectory) {
        this.educationLoanDirectory = educationLoanDirectory;
    }

    public TransactionDirectory getTransactionDirectory() {
        return transactionDirectory;
    }

    public void setTransactionDirectory(TransactionDirectory transactionDirectory) {
        this.transactionDirectory = transactionDirectory;
    }
 
    
      @Override
    public String toString() {
        return this.getName();
    }
    
}
