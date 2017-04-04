/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class OrganizationDirectory {
       
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
       
        if (type.getValue().equals(Organization.Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
//       else if (type.getValue().equals(Organization.Type.BranchManager.getValue())){
//            organization = new BranchManagerOrganization();
//            organizationList.add(organization);
//        }
        else if (type.getValue().equals(Organization.Type.HR.getValue())){
            organization = new HROrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.IT.getValue())){
            organization = new ITOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.CustomerCare.getValue())){
            organization = new CustomerCareOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.BranchClerk.getValue())){
            organization = new BranchClerkOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Loan.getValue())){
            organization = new LoanOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
