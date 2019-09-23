/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author krunal
 */


public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type,String name){
        Organization organization = null;
        if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization(name);
            organizationList.add(organization);
        } else 
        if(type.getValue().equals(Type.College.getValue())){
            organization = new CollegeOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    }
    
    public void removeOrganization(Organization org){
            organizationList.remove(org);
            
    }
}
