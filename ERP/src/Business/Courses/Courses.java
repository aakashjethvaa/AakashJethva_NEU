/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Courses;

import Business.Assignment.AssignmentDirectory;
import Business.College.Program;
import Business.Marks.MarksDirectory;
import Business.Role.TARequest;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class Courses {

    private int crnNumber;
    private String courseName;
    private Program program;
    private int totalSeats;
    private String approvalStatus;
    private UserAccount professor;
    private ArrayList<UserAccount> students;
    private ArrayList<UserAccount> teachingAssistant;
    private AssignmentDirectory assignment;
    private MarksDirectory marks;

    public Courses(int crn, String name, String status, int seats) {
        this.courseName = name;
        this.crnNumber = crn;
        this.approvalStatus = status;
        this.totalSeats = seats;
        students = new ArrayList<UserAccount>();
        teachingAssistant = new ArrayList<UserAccount>();
        requests = new ArrayList<TARequest>();
        assignment = new AssignmentDirectory();
        marks = new MarksDirectory();

    }

    private ArrayList<TARequest> requests;

    public ArrayList<TARequest> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<TARequest> requests) {
        this.requests = requests;
    }

    public TARequest addRequest(Program program, Courses course, UserAccount useraccount) {
        TARequest tar = new TARequest(program, course, useraccount);
        requests.add(tar);
        return tar;
    }

    public AssignmentDirectory getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentDirectory assignment) {
        this.assignment = assignment;
    }

    public MarksDirectory getMarks() {
        return marks;
    }

    public void setMarks(MarksDirectory marks) {
        this.marks = marks;
    }

    public void removeRequest(TARequest tar) {
        requests.remove(tar);
    }

    public ArrayList<UserAccount> getTeachingAssistant() {
        return teachingAssistant;
    }

    public void setTeachingAssistant(ArrayList<UserAccount> teachingAssistant) {
        this.teachingAssistant = teachingAssistant;
    }

    public ArrayList<UserAccount> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<UserAccount> students) {
        this.students = students;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public UserAccount getProfessor() {
        return professor;
    }

    public void setProfessor(UserAccount professor) {
        this.professor = professor;
    }

    public int getCrnNumber() {
        return crnNumber;
    }

    public void setCrnNumber(int crnNumber) {
        this.crnNumber = crnNumber;
    }

    public Program getProgram() {
        return program;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return this.courseName;
    }

    public Boolean RegisterCourse(UserAccount ua) {
        for (UserAccount u : students) {
            if (u.getId() == ua.getId()) {
                return false;
            }
        }
        students.add(ua);
        return true;
    }

    public Boolean AssignTA(UserAccount ua) {
        for (UserAccount u : teachingAssistant) {
            if (u.getId() == ua.getId()) {
                return false;
            }
        }
        teachingAssistant.add(ua);
        return true;
    }

    public Boolean checkStudent(UserAccount ua) {
        for (UserAccount u : students) {
            if (u.getId() == ua.getId()) {

                return true;
            }
        }
        return false;
    }

    public void removeStudent(UserAccount ua) {
        students.remove(ua);
    }

}
