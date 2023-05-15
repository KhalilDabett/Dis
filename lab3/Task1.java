package de.tuhh.diss.lab3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;

public class Task1 {
	static String colorIdentifier(int colorId) {
		switch(colorId) {
		case -1:
			return "None";
		case Color.RED:
			return "Red";
		case Color.GREEN:
			return "Green";
		case Color.BLUE:
			return "Blue";
		case Color.YELLOW:
			return "Yellow";
		case Color.MAGENTA:
			return "Magneta";
		case Color.ORANGE:
			return "Orange";
		case Color.WHITE:
			return "White";
		case Color.BLACK:
			return "Black";
		case Color.PINK:
		    return "Pink";
		case Color.GRAY:
		    return "Gray";
		case Color.LIGHT_GRAY:
			return "Light Gray";
		case Color.DARK_GRAY:
			return "Dark Gray";
		case Color.CYAN:
			return "Cyan";
		case Color.BROWN:
			return "Brown";
		default:
			return "error";	
		}
		
	}

	public static void main(String[] args) {
		
		EV3ColorSensor  colSens = new EV3ColorSensor(SensorPort.S1);
		SensorMode colorId = colSens.getColorIDMode(); 
		float[]	colorA = new float[colorId.sampleSize()];
		
		EV3UltrasonicSensor distSens = new EV3UltrasonicSensor(SensorPort.S4);
		SampleProvider dist = distSens.getDistanceMode();
		float[]	distanceA = new float[dist.sampleSize()];
		
		EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	    EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	    rightMotor.backward();
		leftMotor.backward();
	
		 while(true)
		    {
			 Delay.msDelay(10);
			 LCD.clear();
		     colorId.fetchSample(colorA, 0);
		     int colorNo = (int) colorA[0];
		     LCD.drawString("color is:"+colorIdentifier(colorNo), 0, 5);
		      
		     dist.fetchSample(distanceA, 0);
			 float distance = distanceA[0]*100;
			 LCD.drawString("Distance is:"+distance, 0, 4);
		    
			 if(colorNo != -1) {
				 rightMotor.setSpeed(0);
				 leftMotor.setSpeed(0);
			  }else {
				  rightMotor.setSpeed(100);
				  leftMotor.setSpeed(100); 
			  }
		    } 
		
 
	  }
	
	}


