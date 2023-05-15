package de.tuhh.diss.lab3;

import de.tuhh.diss.lab5.ColorSensor;
import de.tuhh.diss.lab5.Motor;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Task3_3 {
    public static void main(String[] args) {
        
        ColorSensor CS = new ColorSensor();
        DistanceSensor DS = new DistanceSensor();
        Motor M = new Motor();
	
        while(true) {
            
            LCD.drawString("Color is: "+CS.getColorName(), 0, 5);
            LCD.drawString("Distance is: "+DS.getDistanceReading(), 0, 4);
            
            if(CS.getColorName() != "None") {
                
                M.stop();
                
                }else {
                    
                       
                    LCD.clear();
                    M.setSpeed(100);
                    M.moveForward();
                    
                }
        }
    }
}
