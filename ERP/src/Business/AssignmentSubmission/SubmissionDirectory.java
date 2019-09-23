/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AssignmentSubmission;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class SubmissionDirectory {

    private ArrayList<Submission> submission;

    public ArrayList<Submission> getSubmission() {
        return submission;
    }

    public void setSubmission(ArrayList<Submission> submission) {
        this.submission = submission;
    }

    public SubmissionDirectory() {
        submission = new ArrayList<Submission>();
    }

    public Submission addSubmission(String submittedon, String location, UserAccount useraccount) {
        Submission s = new Submission(submittedon, location, useraccount);
        submission.add(s);
        return s;
    }

}
