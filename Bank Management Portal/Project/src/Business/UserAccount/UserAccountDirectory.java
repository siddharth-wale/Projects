/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class UserAccountDirectory {
      private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(int userID, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUserId()==userID && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String password, Employee employee, Role role,Customer customer){
        UserAccount userAccount = new UserAccount();
        
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setCustomer(customer);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
       
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(int userID){
        for (UserAccount ua : userAccountList){
            if (ua.getUserId()==userID){
            return false;
        }
                
        }
        return true;
    }
}
