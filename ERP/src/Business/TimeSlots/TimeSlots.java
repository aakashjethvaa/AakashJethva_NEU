/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TimeSlots;

import Business.Assignment.Assignment;
import Business.UserAccount.UserAccount;

/**
 *
 * @author krunal
 */
public class TimeSlots {

    private Assignment assignment;
    private String date;
    private String start;
    private String end;
    private String status;
    private UserAccount student;
    private UserAccount TA;

    public TimeSlots(String start, String end, String date, String status, UserAccount TA) {
        this.start = start;
        this.end = end;
        this.date = date;
        this.status = status;

        this.TA = TA;

    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getStudent() {
        return student;
    }

    public void setStudent(UserAccount student) {
        this.student = student;
    }

    public UserAccount getTA() {
        return TA;
    }

    public void setTA(UserAccount TA) {
        this.TA = TA;
    }

    @Override
    public String toString() {
        return "TS " + getStart() + "-" + getEnd();
    }

}
