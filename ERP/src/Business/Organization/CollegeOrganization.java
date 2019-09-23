/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.College.ProgramDirectory;
import Business.Role.CollegeAdminRole;
import Business.Role.ProfessorRole;
import Business.Role.ProgramCoordinatorRole;
import Business.Role.ProgramDirectorRole;
import Business.Role.RARole;
import Business.Role.Role;
import Business.Role.StudentRole;
import Business.Role.TARole;
import java.util.ArrayList;

/**
 *
 * @author aakas
 */
public class CollegeOrganization extends Organization{
    
    private ProgramDirectory PD;

    public ProgramDirectory getPD() {
        return PD;
    }

    public void setPD(ProgramDirectory PD) {
        this.PD = PD;
    }
    
    
    public CollegeOrganization(String name){
        super(name);
        PD = new ProgramDirectory();
        
    }

@Override
public ArrayList<Role> getSupportedRole(){
    ArrayList<Role> roles = new ArrayList<>();
    roles.add(new ProfessorRole());
    roles.add(new ProgramCoordinatorRole());
    roles.add(new ProgramDirectorRole());
    roles.add(new StudentRole());
    roles.add(new TARole());
    roles.add(new RARole());
    roles.add(new CollegeAdminRole());
    return roles;
}

}
