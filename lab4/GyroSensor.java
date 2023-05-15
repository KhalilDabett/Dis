package de.tuhh.diss.lab4;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

public class GyroSensor {
    // utilizes Gyrosensor in Lejos robot by getting the accumulated angle
    private EV3GyroSensor gyroSens = new EV3GyroSensor(SensorPort.S3);
    private SampleProvider accuAngle = gyroSens.getAngleMode();
    private float[] angleA = new float[accuAngle.sampleSize()];
    public float getAngleReading() {
        accuAngle.fetchSample(angleA, 0);
        return angleA[0];
    }
    public void resetAngle() {
        gyroSens.reset();
    }

}
