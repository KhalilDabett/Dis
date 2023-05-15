package de.tuhh.diss.lab5;

import de.tuhh.diss.lab3.DistanceSensor;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class MazeSolver {
    
    private Motor motor = new Motor();
    private ColorSensor colorSensor = new ColorSensor();
    private DistanceSensor distanceSensor = new DistanceSensor();
    private String hintColor;
    private String hintDirection;
    private String exitColor;
 
    
    boolean targetIdentified;
    /**
     * Constructor for the three attributes of the class
     * @param hintColor
     * @param hintDirection
     * @param exitColor
     */
    public MazeSolver (String hintColor, String hintDirection, String exitColor) {
        this.hintColor = hintColor;
        this.hintDirection = hintDirection;
        this.exitColor = exitColor;
    }
    /**
     * moves robot until barrier is detected, then identifies color and returns it
     * @return Color of barrier
     */
    public String searchNextBarrier(){
       
        while(true) {
            
            motor.setSpeed(1000);    
            motor.moveForward();
            
            String color = colorSensor.getColorName();
            float distancetoBarrier = distanceSensor.getDistanceReading();
            
            LCD.drawString(colorSensor.getColorName(), 0, 1);
            LCD.drawString(""+distanceSensor.getDistanceReading(), 0, 2);
            Delay.msDelay(1);
            LCD.clear();
            
            if( distancetoBarrier < 3f ) {
                
                motor.setSpeed(0);
                if (color == "None") {
                    color = colorSensor.getColorNameRGB();    
                }
                while(true) {
                    
                    if(distanceSensor.getDistanceReading() <= 10f) {
                        
                        motor.moveBackward();
                        LCD.clear();
                        LCD.drawString(colorSensor.getColorName(), 0, 1);
                        LCD.drawString(""+distanceSensor.getDistanceReading(), 0, 2);
                        Delay.msDelay(1);
                        motor.setSpeed(100);
                        
                    }else {
                        
                        motor.setSpeed(0);
                        motor.stop();
                        return color;
                        
                    }
                }
            }
        }
    }
    
    /**
     * motor turns to the appropriate diraction according to previously detected color
     * @param currentColor
     * @return T/F whether barrier is target barrier or not
     */
    public boolean reactToBarrier(String currentColor) {
        
        if (currentColor == this.hintColor) {
            if(this.hintDirection == "Right") {
            motor.turn(90);
            }else {
                motor.turn(-90);  
            }
            return false;
        }else
            if (currentColor == "Black" || currentColor == "Orange") {    
            motor.turn(-90);
            if(distanceSensor.getDistanceReading() < 40) {
                motor.turn(180);
                return false;
            }else {
                return false;
            }
        }else{
            boolean position1 = false;
            boolean position2 = false;
            boolean position3 = false;
            if (currentColor == exitColor) {
                position1 = true;   
            }
            motor.turn(-90);
            currentColor = this.searchNextBarrier();
            if(currentColor == exitColor) {
                position2 = true;   
            }
            motor.turn(180);
            currentColor = this.searchNextBarrier();
            if(currentColor == exitColor) {
                position3 = true;
                return true;
            }
            if (position1 == true) {
                motor.turn(-90);
                return true;
            }else if (position2 == true) {
                motor.turn(180);
                return true;
            } 
        }
        while(true) {
            motor.turn(90);
            if (distanceSensor.getDistanceReading() > 35 ) {
            return false;
            }
        }
    }
}
