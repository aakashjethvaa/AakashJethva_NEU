/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.College.Program;
import Business.Courses.Courses;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.ProfessorRole.ManageCourseProfJPanel;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author aakas
 */
public class ProfessorRole extends Role {

    private ArrayList<UserAccount> researchAssistants;
    private ArrayList<RARequest> RArequests;
    
    public ProfessorRole(){
        researchAssistants = new ArrayList<UserAccount>();
        RArequests = new ArrayList<RARequest>();
                
    }

    
    public RARequest addRequest(UserAccount professor, UserAccount useraccount) {
        RARequest tar = new RARequest(professor, useraccount);
        RArequests.add(tar); 
        return tar; 
    }

    public void removeRequest(RARequest r){
        RArequests.remove(r);
    }
    public ArrayList<RARequest> getRArequests() {
        return RArequests;
    }

    public void setRArequests(ArrayList<RARequest> RArequests) {
        this.RArequests = RArequests;
    }

    
    
    
    
    public ArrayList<UserAccount> getResearchAssistants() {
        return researchAssistants;
    }

    public void setResearchAssistants(ArrayList<UserAccount> researchAssistants) {
        this.researchAssistants = researchAssistants;
    }
    
     public Boolean AssignRA(UserAccount ua) {
        for (UserAccount u : researchAssistants) {
            if (u.getId() == ua.getId()) {
                return false;
            }
        }
        researchAssistants.add(ua);
        return true;
    }
     
     
     
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network) {
        return new ManageCourseProfJPanel(userProcessContainer, organization, account);
    }

    @Override
    public String toString() {
        return "Professor";
    }
}
