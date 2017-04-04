/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Session.SessionLog;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public abstract class Role {
     public enum RoleType{
        Admin("Admin"),
        HR("HR"),
        ITOfficer("IT Officer"),
        CustomerCare("Customer Care"),
        BranchClerk("Branch Clerk"),
        LoanOfficer("Loan Officer"),
        Customer("Customer");
      
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Business business,SessionLog session);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
