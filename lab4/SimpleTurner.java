package de.tuhh.diss.lab4;

import de.tuhh.diss.lab5.Motor;

public class SimpleTurner implements Turner{
    //Turns robot to desired angle through the rotate method in class Motor
    private Motor motor = new Motor();
    // instance of class motor that can control EV3Motor with simple methods (avoids need to continuously call right and left motor
    
    public void setSpeed(int degreesPerSecond) {
       motor.setSpeed(degreesPerSecond);
    }
    
    public void turn(int degrees) { 
        int magnitude  = (55/9) *degrees;    //determine angle the Gear need to turn so that the robot turns with required angle
        motor.rotate(magnitude);
    }
    
}




