/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TimeSlots;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author krunal
 */
public class TimeSlotsDirectory {
    
    private ArrayList<TimeSlots> slots;
    
    public TimeSlotsDirectory(){
        slots = new ArrayList<TimeSlots>();
    }
    

    public ArrayList<TimeSlots> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<TimeSlots> slots) {
        this.slots = slots;
    }
    
    public TimeSlots addTimeSlot(String start,String end,String date,String status,UserAccount TA){
        TimeSlots ts = new TimeSlots(start,end,date,status,TA);
        slots.add(ts);
        return ts;
    }
    public void removeTimeSlots(TimeSlots ts){
        slots.remove(ts);
    }
}
