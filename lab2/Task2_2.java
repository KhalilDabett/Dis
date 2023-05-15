package de.tuhh.diss.lab2;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Task2_2 {
	public static void main(String[] args) {
	EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	rightMotor.setSpeed(100);
	rightMotor.forward();
	Delay.msDelay(10000);
	rightMotor.isMoving();
	rightMotor.stop();
	
	EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
	leftMotor.setSpeed(100);
	leftMotor.forward();
	Delay.msDelay(10000);
	leftMotor.isMoving();
	leftMotor.stop();


}
}
