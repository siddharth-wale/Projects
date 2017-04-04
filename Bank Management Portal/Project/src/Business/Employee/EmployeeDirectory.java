/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author admin
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory(){
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

   

  
     public Employee addEmployee(String Name,Date DateOfBirth,String Address,
             int MobileNumber,int SSNNumber,String EmailAddress)
    {
        Employee e= new Employee();
        e.setName(Name);
        e.setAddress(Address);
        e.setDateOfBirth(DateOfBirth);
       
        e.setMobileNumber(MobileNumber);
        e.setSsnNumber(SSNNumber);
       
        e.setEmailAddress(EmailAddress);
        employeeList.add(e);
        return e;
    }
 
}
