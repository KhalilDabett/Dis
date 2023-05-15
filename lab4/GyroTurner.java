package de.tuhh.diss.lab4;


import java.lang.Math;

import de.tuhh.diss.lab5.Motor;
import lejos.hardware.lcd.LCD;

public class GyroTurner implements Turner{
    //Turns robot to desired angle through feedback from accumulated angle acquired through class GyroSesnor
    private Motor motor = new Motor();
    private GyroSensor gyroSensor = new GyroSensor();
    
    public void setSpeed(int degreesPerSecond) {
        motor.setSpeed(degreesPerSecond);
        
    }
    
    public void turn(int degrees) {
        if (degrees > 0) {
            motor.rotateClockwise();
        }else if(degrees<0){
            motor.rotateAnticlockwise();
        }
        while(true) {
            
            if (Math.abs(gyroSensor.getAngleReading()) >= Math.abs(degrees)) {
                motor.stop();
                LCD.drawString("Angle:"+gyroSensor.getAngleReading(), 0, 5);
                
            }
        }
        
    }
    
    
   
    
        
        
      
        
    

}
