/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Marks;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author karan
 */
public class MarksDirectory {

    private ArrayList<Marks> marks;

    public ArrayList<Marks> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Marks> marks) {
        this.marks = marks;
    }

    public MarksDirectory() {
        marks = new ArrayList<>();
    }

    public ArrayList<Marks> getMarksList() {
        return marks;
    }
    
    public Marks addMarks(UserAccount ua,String grade){
        Marks mm = new Marks( ua,grade);
        marks.add(mm);
        return mm;
    }
    
    public void removeMarks(Marks m){
        marks.remove(m);
    }
    
    public Marks checkStudent(UserAccount ua){
        for(Marks m : marks){
            if(m.getStudent().getId() == ua.getId())
                return m;
        }
        return null;
    }
    
    
}
