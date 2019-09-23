/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.College.Program;
import Business.Courses.Courses;
import Business.UserAccount.UserAccount;

/**
 *
 * @author krunal
 */
public class RARequest {
    
    private UserAccount professor;
    private UserAccount ua;
    private String status;

    
    
    public RARequest(UserAccount professor, UserAccount useraccount) {
      this.professor = professor;
      this.ua = useraccount; 
      this.status = "Initiated";       
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getProfessor() {
        return professor;
    }

    public void setProfessor(UserAccount professor) {
        this.professor = professor;
    }
    
    
    

    public UserAccount getUa() {
        return ua;
    }

    public void setUa(UserAccount ua) {
        this.ua = ua;
    }
    
    @Override
    public String toString(){
        return ua.getEmployee().getName();
    }
}
