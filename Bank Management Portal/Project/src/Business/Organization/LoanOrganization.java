/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LoanOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class LoanOrganization extends Organization{
       public LoanOrganization() {
        super(Organization.Type.Loan.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LoanOfficerRole());
        return roles;
    }
     
}
