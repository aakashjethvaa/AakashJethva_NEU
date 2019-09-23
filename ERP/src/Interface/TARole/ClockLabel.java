/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.TARole;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author krunal
 */
class ClockLabel extends JLabel implements ActionListener {
 
  String type;
  SimpleDateFormat sdf;
  int tt;
  int m;
  int h;
 
  public ClockLabel(String type,int h,int m,int tt) {
     this.h = h;
     this.m = m;
     this.tt = tt;
     
    this.type = type;
    setForeground(Color.green);
 
    sdf = new SimpleDateFormat("HH:mm:ss");
    setFont(new Font("sans-serif", Font.PLAIN, 40));
    setHorizontalAlignment(SwingConstants.CENTER);
    
    Timer t = new Timer(1000, this);
    t.start();
  }
   
  public void actionPerformed(ActionEvent ae) {
    
    if(tt==59){
       
        
        if(m==59){
           
            
            if(h == 23){
                h=0;
                tt=0;
                m=0;
            }else{
             h+=1;
             m=0;
            }
        }else{
        m+=1;
        tt=0;
        }
    }else{  
    tt+=1;
    }
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY,h);
    cal.set(Calendar.MINUTE,m);
    cal.set(Calendar.SECOND,  tt);
    cal.set(Calendar.MILLISECOND,0);

Date d = cal.getTime();
      
  Date date = new Date();
  setText(sdf.format(d));
  }

    
}
