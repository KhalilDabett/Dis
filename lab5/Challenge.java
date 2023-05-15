package de.tuhh.diss.lab5;

import de.tuhh.diss.lab3.DistanceSensor;
import de.tuhh.diss.lab4.GyroTurnerWithFeedback;
import lejos.hardware.lcd.LCD;

public class Challenge {

    public static void main(String[] args) {
        
        
        /*new instance of mazesolver wiht yelllow as hint color, right as hint direction 
         * and blue as target color*/
        MazeSolver mazeSolver = new MazeSolver("Yellow","Right","Ble");
        
        
        while(true) {
            String CurrentColor = mazeSolver.searchNextBarrier();
            boolean c = mazeSolver.reactToBarrier(CurrentColor);
            if (c == true) {
                break;
            }
            
   
        }
        
    
        
    }
}
