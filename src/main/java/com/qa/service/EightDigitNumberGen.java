package com.qa.service;

import java.util.Random;

import com.qa.constants.Constants;

public class EightDigitNumberGen {

	public String generateEightDigitNumber() {

		Random rand = new Random();
		Integer num = rand.nextInt(Constants.EIGHT_DIGIT_UPPER_LIMIT) + Constants.EIGHT_DIGIT_LOWER_LIMIT;

		return num.toString();

	}
	
	

}
