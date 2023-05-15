package de.tuhh.diss.lab3;
import lejos.robotics.SampleProvider;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class Task3_2 {

	public static void main(String[] args) {
		EV3UltrasonicSensor distSens = new EV3UltrasonicSensor(SensorPort.S4);
		SampleProvider dist = distSens.getDistanceMode();
		int a  = dist.sampleSize();
		float[] reading = new float[a];
		distSens.fetchSample(reading,3);
		float b = reading[3];
		
		// TODO Auto-generated method stub

	}

}
