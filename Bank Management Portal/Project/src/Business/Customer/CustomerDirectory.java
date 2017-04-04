/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Customer.Customer;
import Business.Enterprise.Enterprise;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author admin
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;
    
    public CustomerDirectory()
    {
        customerList= new ArrayList<>();
    }

    /**
     * @return the customerList
     */
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * @param customerList the customerList to set
     */
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public Customer addCustomer(String Name,Date DateOfBirth,String Address,
             int MobileNumber,int SSNNumber,String EmailAddress,
             int RoutingNumber,String SwiftCode,String BranchName,int Balance)
    {
        Customer customer= new Customer();
//        customer.setAccountNumber(AccountNumber);
        customer.setAddress(Address);
        customer.setBalance(Balance);
        customer.setBranchName(BranchName);
        customer.setDateOfBirth(DateOfBirth);
        customer.setEmailAddress(EmailAddress);
        customer.setMobileNumber(MobileNumber);
        customer.setName(Name);
        customer.setRoutingNumber(RoutingNumber);
        customer.setSsnNumber(SSNNumber);
        customer.setSwiftCode(SwiftCode);
//        customer.setEnterprise(enterprise);
        customerList.add(customer);
        return customer;
    }

  
}
