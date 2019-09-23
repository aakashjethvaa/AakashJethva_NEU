/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Courses.Courses;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.RARole.RAWorkAreaJPanel;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author aakas
 */
public class RARole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,Network network) {
        return new RAWorkAreaJPanel(userProcessContainer, organization,account);   
}
    @Override
    public String toString(){
        return "Research Assistant";
    }
    
    
    private ArrayList<RAHours> rAHours;

    private RAHours active;
    private Boolean rahours;
    private Courses course;
    
    public RARole(){
        rAHours = new ArrayList<RAHours>();
        active = new RAHours();
        rahours = false;
    }

    public ArrayList<RAHours> getrAHours() {
        return rAHours;
    }

    public void setrAHours(ArrayList<RAHours> rAHours) {
        this.rAHours = rAHours;
    }

    public RAHours getActive() {
        return active;
    }

    public void setActive(RAHours active) {
        this.active = active;
    }

    public Boolean getRahours() {
        return rahours;
    }

    public void setRahours(Boolean rahours) {
        this.rahours = rahours;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
    
    
    public RAHours addRAHours(){
        RAHours tt = new RAHours();
        rAHours.add(tt);
        return tt;
    }
    
    
}