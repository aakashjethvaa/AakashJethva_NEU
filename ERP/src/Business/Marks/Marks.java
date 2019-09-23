/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Marks;

import Business.Assignment.Assignment;
import Business.Courses.Courses;
import Business.UserAccount.UserAccount;

/**
 *
 * @author karan
 */
public class Marks {

    private String marks;
    
    private UserAccount Student;
    private Courses course;
    
    

    
     
    public Marks(UserAccount ua,String marks){
        this.marks = marks;
        this.Student =ua;
    } 
    
    public UserAccount getStudent() {
        return Student;
    }

    public void setStudent(UserAccount Student) {
        this.Student = Student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    
    
    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    

}
