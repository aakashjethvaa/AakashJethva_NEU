/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Assignment;

import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class AssignmentDirectory {

    private ArrayList<Assignment> assignmentDirectory;

    public AssignmentDirectory() {
        assignmentDirectory = new ArrayList<Assignment>();
    }

    public ArrayList<Assignment> getAssignmentDirectory() {
        return assignmentDirectory;
    }

    public void setAssignmentDirectory(ArrayList<Assignment> assignmentDirectory) {
        this.assignmentDirectory = assignmentDirectory;
    }

    public Assignment addAssignment(String name, String problem, int maxScore) {
        Assignment as = new Assignment(name, problem, maxScore);
        assignmentDirectory.add(as);
        return as;
    }
    
    public void removeAssignment(Assignment a){
        assignmentDirectory.remove(a);
    }
}
