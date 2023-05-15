package de.tuhh.diss.lab3;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Task4_2_draft {

    public static void main(String[] args) {
        
        Motor M = new Motor();
        GyroSensor GS = new GyroSensor();
        M.setSpeed(100);
        M.rotateL(55/9);
        M.rotateR(-55/9);
        while(true) {
            
        float angle= GS.getAngleReading();
        LCD.drawString("Angle:"+angle, 0, 5);    
        
       
        
        
        
        
        }
        
       
        

    }

}
