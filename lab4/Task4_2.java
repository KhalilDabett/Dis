package de.tuhh.diss.lab4;

import lejos.hardware.lcd.LCD;

public class Task4_2 {

   public static void main(String[] args) {
       
        GyroSensor gyroSensor = new GyroSensor();
        SimpleTurner S = new SimpleTurner();
        
        S.setSpeed(100);
        S.turn(50);
        LCD.drawString("Angle = "+(-gyroSensor.getAngleReading()), 0, 5);
       
         
    }
}


