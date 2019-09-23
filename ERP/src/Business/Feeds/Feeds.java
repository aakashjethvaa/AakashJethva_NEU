/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Feeds;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author karan
 */
public class Feeds {

    private String message;
    private String messageTime;
    
    public Feeds(String message){
        this.message = message;
        String timestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
        this.messageTime = timestamp;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

}
