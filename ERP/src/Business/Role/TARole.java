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
import Interface.TARole.TAWorkAreaJPanel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author aakas
 */
public class TARole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network) {
        try {
            return new TAWorkAreaJPanel(userProcessContainer, organization, account);
        } catch (ParseException ex) {
            Logger.getLogger(TARole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Teaching Assistant";
    }
    
    private ArrayList<TAHours> tahours;

    private TAHours active;
    private Boolean taHours;
    private Courses course;
    
    public TARole(){
        tahours = new ArrayList<TAHours>();
        active = new TAHours();
        taHours = false;
    }

    public TAHours getActive() {
        return active;
    }

    public void setActive(TAHours active) {
        this.active = active;
    }
    
    
    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public ArrayList<TAHours> getTahours() {
        return tahours;
    }

    public void setTahours(ArrayList<TAHours> tahours) {
        this.tahours = tahours;
    }
    
    public TAHours addTAHours(){
        TAHours tt = new TAHours();
        tahours.add(tt);
        return tt;
    }
    
    

    public Boolean getTaHours() {
        return taHours;
    }

    public void setTaHours(Boolean taHours) {
        this.taHours = taHours;
    }

    

}
