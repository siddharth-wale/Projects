/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ITOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ITOrganization extends Organization{
       public ITOrganization() {
        super(Organization.Type.IT.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ITOfficerRole());
        return roles;
    }
}
