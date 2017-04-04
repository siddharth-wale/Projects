package Business.UserAccount;



import Business.Customer.Customer;
import Business.Employee.Employee;
import static Business.Organization.Organization.Type.Customer;
import Business.Person.Person;
import Business.Role.Role;
import Business.Session.SessionDirectory;
import Business.WorkQueue.WorkQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class UserAccount {
     private int userId;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private Employee employee;
    private Customer customer;
    private static int count = 1000;
    private int attempt =0;
    private SessionDirectory sessionDirectory;
    
   

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
//    public static final String LOANDEPARTMENT_Role= "loanDepartment"; 
//    public static final String CUSTOMER_Role= "customer";
//    public static final String EMPLOYEE_Role= "employee";
//    public static final String CUSTOMERCARE_Role="customerCare";
   
    public UserAccount() {
        workQueue = new WorkQueue();
        userId= ++count;
        sessionDirectory = new SessionDirectory();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

  
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    

    public void setRole(Role role) {
        this.role = role;
    }

    public SessionDirectory getSessionDirectory() {
        return sessionDirectory;
    }

    public void setSessionDirectory(SessionDirectory sessionDirectory) {
        this.sessionDirectory = sessionDirectory;
    }
    
      @Override
    public String toString() {
        return String.valueOf(userId);
    }
    
}
