package de.tuhh.diss.lab2;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

public class task2_3_mod {
	public static class Property{
		public int value;
		private int max_value;
		public Property(int value,int max_value){
			this.value=value;
			this.max_value=max_value;
		}
		public int increment(){
			if (value<max_value) {
				return value++;
			}else {
				return value=0;
			}
		}
		public int decrement(){
			if (value>0) {
				return value--;
			}else {
				return value=max_value;
			}
		}
		public int getValue() {
			return this.value;
		}
	}
	static void Screen(int pointer_pos, int v){
		if (pointer_pos!=1) {
			LCD.drawString("Menu", 0, 1);
		}else {
			LCD.drawString(">Menu", 0, 1);
		}
		if (pointer_pos!=2) {
			LCD.drawString("Volume ", 0, 2);
		}else {
			LCD.drawString(">Volume ", 0, 2);
		}
		if (pointer_pos!=3){
			LCD.drawString("Frequency ", 0, 3);
		}else {
			LCD.drawString(">Frequency ", 0, 3);
		}
		if(pointer_pos!=4) {
			LCD.drawString("Duration ", 0, 4);
		}else {
			LCD.drawString(">Duration ", 0, 4);
		}
		if (pointer_pos!=5) {
			LCD.drawString("Play", 0, 5);
		}else {
			LCD.drawString(">Play", 0, 5);
		}
	}

	public static void main(String[] args) {
		int x = 1;
		Property volume = new Property(0,50);
		int freq =0;
		int duration= 0;
		int n=1;
		int v = volume.getValue();
		while (x==1) {
			Screen(n,v);
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
		}
			}
		// TODO Auto-generated method stub

	}
