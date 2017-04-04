/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.BranchClerkOrganization;
import Business.Organization.Organization;
import Business.Session.SessionLog;
import Business.UserAccount.UserAccount;
import UserInterfaceEmployee.EmployeeWorkAreaJPanel;

import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class BranchClerkRole extends Role{

@Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Business.Business business,SessionLog session) {
        return new EmployeeWorkAreaJPanel(userProcessContainer, account, (BranchClerkOrganization)organization, enterprise,session);
    }
}
