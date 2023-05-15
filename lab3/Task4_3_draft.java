package de.tuhh.diss.lab3;

import lejos.hardware.lcd.LCD;


public class Task4_3_draft {

    public static void main(String[] args) {
        
        Motor M = new Motor();
        GyroSensor GS = new GyroSensor();
        M.setSpeed(100);
        while (true) {
           
            
            float angle= GS.getAngleReading();
            if (angle >= 180.0) {
                M.setSpeed(0);
            }else {
                M.rotatecont();
            }
            
            LCD.drawString("Angle:"+angle, 0, 5);
            
        }
       
        

    }

}


