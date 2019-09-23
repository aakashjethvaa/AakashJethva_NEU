/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.College;

import Business.Courses.CourseDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author krunal
 */
public class Program {

    private String name;
    private int id;
    private static int count = 1;
    private ArrayList<UserAccount> students;
    private UserAccount programDirector;
    private UserAccount programCoordinator;
    private CourseDirectory courses;
    private UserAccount professor;

    public CourseDirectory getCourses() {
        return courses;
    }

    public UserAccount getProfessor() {
        return professor;
    }

    public void setProfessor(UserAccount professor) {
        this.professor = professor;
    }

    public void setCourses(CourseDirectory courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<UserAccount> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<UserAccount> students) {
        this.students = students;
    }

    public UserAccount getProgramDirector() {
        return programDirector;
    }

    public void setProgramDirector(UserAccount programDirector) {
        this.programDirector = programDirector;
    }

    public UserAccount getProgramCoordinator() {
        return programCoordinator;
    }

    public void setProgramCoordinator(UserAccount programCoordinator) {
        this.programCoordinator = programCoordinator;
    }

    public Program(String name) {
        this.name = name;
        this.id = count;
        students = new ArrayList<UserAccount>();
        courses = new CourseDirectory();
        count++;
    }

    public Boolean subscribeProgram(UserAccount ua) {
        for (UserAccount u : students) {
            if (u.getId() == ua.getId()) {
                return false;
            }
        }
        students.add(ua);
        return true;
    }
    
    public void unsubscribe(UserAccount ua){
        students.remove(ua);
    }

   

    public Boolean checkStudent(UserAccount ua){
        for(UserAccount u : students){
            if(u.getId() == ua.getId()){

                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
