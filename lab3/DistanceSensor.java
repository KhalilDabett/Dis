package de.tuhh.diss.lab3;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class DistanceSensor {
	
    private EV3UltrasonicSensor distSens = new EV3UltrasonicSensor(SensorPort.S4);
    private SampleProvider dist = distSens.getDistanceMode();
    private float[]	distanceA = new float[dist.sampleSize()];
	
    public float getDistanceReading() {
	    
	    dist.fetchSample(distanceA, 0);
	    float distance = distanceA[0]*100;
	    return distance;
    }

}
