package de.tuhh.diss.lab3;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

public class GyroSensor {
    EV3GyroSensor gyroSens = new EV3GyroSensor(SensorPort.S3);
    SampleProvider accuAngle = gyroSens.getAngleMode();
    float[] angleA = new float[accuAngle.sampleSize()];
    public float getAngleReading() {
        accuAngle.fetchSample(angleA, 0);
        float angle = angleA[0];
        return angle;
    }

}
