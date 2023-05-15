package de.tuhh.diss.lab3;

import de.tuhh.diss.lab5.Motor;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;


public class task3_4 {

	public static void main(String[] args) {
	    Motor M = new Motor();
		GyroSensor GS = new GyroSensor();
		int noOfTurns = 0;
		while (true) {
		    
		    int angle= (int)GS.getAngleReading();
		    Delay.msDelay(100);
		    if (angle % 360 == 0) {
		        noOfTurns=noOfTurns+1;
		    }
			LCD.drawString("No of T="+noOfTurns, 0, 5);
			M.setSpeed(100);
			M.rotateR(50);
		}
		// TODO Auto-generated method stub

	}

}
