/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Courses;

import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class CourseDirectory {

    private ArrayList<Courses> courseList;

    public CourseDirectory() {
        courseList = new ArrayList<>();
    }

    public ArrayList<Courses> getCourseList() {
        return courseList;
    }

    public Courses createCourse(int crn, String name, String status, int totalSeats) {
        Courses cc = new Courses(crn, name, status, totalSeats);
        courseList.add(cc);
        return cc;
    }

    public void removeCourse(Courses cc) {
        courseList.remove(cc);
    }
}
