package com.qa.service;

import java.util.Random;

public class LetterGen {
	private Random rand = new Random();

	public String generateLetter() {

		int letterNum = rand.nextInt(3);
		switch (letterNum) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
			
		default:
			return "Invalid number";
		
		}

	}
	
	public static String thisIsAClassMethod() {
		return "";
	}

}
