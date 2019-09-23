/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AssignmentSubmission;

import Business.UserAccount.UserAccount;

/**
 *
 * @author karan
 */
public class Submission {

    private String submittedOn;
    private UserAccount student;
    private String path;
    private int marks;

    public Submission(String submittedon, String path, UserAccount useraccount) {
        this.submittedOn = submittedon;
        this.path = path;
        this.student = useraccount;
        this.marks = 0;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    
    public String getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UserAccount getStudent() {
        return student;
    }

    public void setStudent(UserAccount student) {
        this.student = student;
    }

}
