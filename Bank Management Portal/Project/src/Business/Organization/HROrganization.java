/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HRRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class HROrganization extends Organization{
    
       public HROrganization() {
        super(Organization.Type.HR.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HRRole());
        return roles;
    }
}
