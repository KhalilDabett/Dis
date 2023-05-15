package de.tuhh.diss.lab3;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Motor {
	
    private EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
    private EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    
    public void setSpeed(int speed){
        rightMotor.setSpeed(speed);
        leftMotor.setSpeed(speed);
		
    }
    
    public void moveForward(){
        rightMotor.backward();
        leftMotor.backward();
    }
      
    public void moveBackward(){
        rightMotor.forward();
        leftMotor.forward();
    }
    
    public void stop(){
        rightMotor.stop(true);
        leftMotor.stop();
    }
    public void rotateR(int angle){
        rightMotor.rotate(angle,true);
    }
    public void rotateL(int angle) {
        leftMotor.rotate(angle,true);
    }
}
