package de.tuhh.diss.lab4;

import lejos.hardware.lcd.LCD;


import java.lang.Math;

import de.tuhh.diss.lab5.Motor;

public class GyroTurnerWithFeedback {
    
    private Motor motor = new Motor();
    private GyroSensor gyroSensor = new GyroSensor();

    
    
    public void turn(int degrees) {
        motor.setSpeed(100);
        if (degrees > 0) {
            motor.rotateClockwise(); 
        }else if( degrees < 0){
            motor.rotateAnticlockwise();    
        }
        while(true) {
        float currentOrientation = gyroSensor.getAngleReading();
        
        int deviation = (int) Math.abs(degrees) - (int)Math.abs(currentOrientation);
        
        if (deviation < 10)
        motor.setSpeed(deviation*1/100);
        LCD.drawString("Angle:"+currentOrientation, 3, 5);
        LCD.drawString("" + deviation, 4, 6);
        
        }
    }

}
