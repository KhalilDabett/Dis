package de.tuhh.diss.lab2;
import lejos.hardware.Sound;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class Task2_3 {

	public static void main(String[] args) {
		int n=1;
		int x=1;
		int volume=0;
		int freq=0;
		int duration=0;
	
		while (x==1) {
		if (n==1) {
		LCD.drawString(">Menu", 0, 1);
		LCD.drawString("volume "+volume, 0, 2);
		LCD.drawString("Frequency "+freq, 0, 3);
		LCD.drawString("Duration "+duration, 0, 4);
		LCD.drawString("play", 0, 5);
		
		    }
		if (n==2) {
			LCD.drawString("Menu", 0, 1);
			LCD.drawString(">volume "+volume, 0, 2);
			LCD.drawString("Frequency "+freq, 0, 3);
			LCD.drawString("Duration "+duration, 0, 4);
			LCD.drawString("play", 0, 5);
			
			}
		if (n==3) {
			LCD.drawString("Menu", 0, 1);
			LCD.drawString("volume "+volume, 0, 2);
			LCD.drawString(">Frequency "+freq, 0, 3);
			LCD.drawString("Duration "+duration, 0, 4);
			LCD.drawString("play", 0, 5);
			
			}
		if (n==4) {
			LCD.drawString("Menu", 0, 1);
			LCD.drawString("volume "+volume, 0, 2);
			LCD.drawString("Frequency "+freq, 0, 3);
			LCD.drawString(">Duration "+duration, 0, 4);
			LCD.drawString("play", 0, 5);
			
			}
		if (n==5) {
			LCD.drawString("Menu", 0, 1);
			LCD.drawString("volume "+volume, 0, 2);
			LCD.drawString("Frequency "+freq, 0, 3);
			LCD.drawString("Duration "+duration, 0, 4);
			LCD.drawString(">play"+n, 0, 5);
			
			}
		Button.waitForAnyPress();
		if (Button.DOWN.isDown()) {
			if (n==5) {
				n=1;
			}
			else {
			n=n+1;
			LCD.clear();
			}
		}
		if (Button.UP.isDown()) {
			if (n==1) {
				n=5;
			}else {
			n=n-1;
			LCD.clear();
			}
			}
			if(Button.RIGHT.isDown()){
				if(n==2) {
					volume=volume+1;
					Sound.setVolume(10);
				}
				if(n==3) {
					freq=freq+1;
				}
				if(n==4) {
					duration=duration+1;
				}
			}
			if(Button.LEFT.isDown()){
				if(n==2) {
					volume=volume-1;
					Sound.setVolume(volume);
				}
				if(n==3) {
					freq=freq-1;
				}
				if(n==4) {
					duration=duration-1;
				}
			}
		
		
		}
		
		
		// TODO Auto-generated method stub

	}

}
