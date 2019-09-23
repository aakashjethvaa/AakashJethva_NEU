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
public class TARequest {
    
    Program program;
    Courses course;
    UserAccount ua;
    String status;

    
    
    public TARequest(Program program, Courses course, UserAccount useraccount) {
      this.program = program;
      this.course = course;
      this.ua = useraccount;
      this.status = "Initiated";       
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
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
