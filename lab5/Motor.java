package de.tuhh.diss.lab5;

import de.tuhh.diss.lab4.GyroSensor;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Motor {
    // instance of class motor that can control EV3Motor with simple methods (avoids need to continuously call right and left motor
    private EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
    private EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
    private GyroSensor gyroSensor = new GyroSensor();
    
    /**
     * set speed of right and left motor to this speed
     * @param speed
     */
    public void setSpeed(int speed){
        
        rightMotor.setSpeed(speed);
        leftMotor.setSpeed(speed);
		
    }
    /**
     * set both right and left motor to moving forward condition
     */
    public void moveForward(){
        
        rightMotor.backward();
        leftMotor.backward();
    }
    
    /**
     * set both right and left motor to moving backward condition
     */
    public void moveBackward(){
      
        rightMotor.forward();
        leftMotor.forward();
    }
 
    /**
     * stop both motors
     */
    public void stop(){
        
        rightMotor.stop();
        leftMotor.stop();
    }
    
    /**
     * rotate left and right motor in opposite directions with value=magnitude to achieve rotation  of robot
         
     * @param magnitude positive for clockwise negative for anti-clockwise
     */
    public void rotate(int magnitude){  
        
        rightMotor.rotate(magnitude,true);
        leftMotor.rotate(-magnitude);
    }
  
    /**
     * rotate left and right motor in opposite directions continuously to achieve continuous clockwise rotation  of robot
     */
    public void rotateClockwise() {
        
        rightMotor.forward();
        leftMotor.backward();
    }
    /**
     * rotate left and right motor in opposite directions continuously to achieve continuous clockwise rotation  of robot
     */
    public void rotateAnticlockwise() {
        
        leftMotor.forward();
        rightMotor.backward();
    }
    
    /**
     * Turns robot required angle using the gyrosensor with a feedback to ensure target degree is not exceeded
     * @param degrees
     */
    public void turn(int degrees) {
        this.setSpeed(100);
        if (degrees > 0) {
            this.rotateClockwise(); 
        }else if( degrees < 0){
            this.rotateAnticlockwise();    
        }
        while(true) {
            
        float currentOrientation = gyroSensor.getAngleReading();
        float deviation = (float) Math.abs(degrees) - Math.abs(currentOrientation);
        
        if (deviation < 5.0f) {
        this.setSpeed((int)deviation*1/100);
        
        }
        if (deviation == 0) {
            gyroSensor.resetAngle();
            break;
        }
        }
    }
    
}
