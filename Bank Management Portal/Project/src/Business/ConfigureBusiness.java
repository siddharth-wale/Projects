/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Person.PersonDirectory;
import Business.Person.Person;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.jar.Attributes.Name;

/**
 *
 * @author admin
 */
public class ConfigureBusiness {
    
    public static void addOrganization(Enterprise enterprise){
        for(Type type: Organization.Type.values()){
            enterprise.getOrganizationDirectory().createOrganization(type);
        }
        
    }
    
  public static Business configure(){
        
        Business business = Business.getInstance();
        
      
        
        
        Employee employee = business.getEmployeeDirectory().addEmployee("sysadmin", new Date(), null, 0, 0, null);
        
        
        UserAccount ua = business.getUserAccountDirectory().createUserAccount("sysadmin", employee, new SystemAdminRole(),null);
        
        for(Network n : business.getNetworkList()){
            System.out.println(n.getName());
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                
                 addOrganization(e);
                      
                 }
                 
            }
        
        return business;
    }

 
}
