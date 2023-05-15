package de.tuhh.diss.lab5;

import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;

public class ColorSensor{
	
    private EV3ColorSensor colSens = new EV3ColorSensor(SensorPort.S1);
    private SensorMode colorId = colSens.getColorIDMode(); 
    private float[]	colorA = new float[colorId.sampleSize()];
    
   
    SampleProvider rgbSensor = colSens.getRGBMode();
    float[] rgbSample = new float[rgbSensor.sampleSize()];
	
    public String getColorName() {
		
        colorId.fetchSample(colorA, 0);
        int colorNo = (int) colorA[0];
        return colorIdentifier(colorNo);
	}
    
    public String getColorNameRGB() {
        
        
        
        rgbSensor.fetchSample(rgbSample, 0);
        float redDegree = rgbSample[0];
        float greenDegree = rgbSample[1];
        float blueDegree =  rgbSample[2];
        if (blueDegree > redDegree) {
            if (blueDegree > greenDegree) {
                return "Blue";
            }
        }
        return "None";
        
    
}
	
    private String colorIdentifier(int colorId) {
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
}
	

