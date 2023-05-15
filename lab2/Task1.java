package de.tuhh.diss.lab2;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Task1 {

	public static void main(String[] args) {
		LCD.drawString("Hello LeJos! ", 0, 4);
		Delay.msDelay(5000);
	}

}
