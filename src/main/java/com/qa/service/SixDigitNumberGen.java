package com.qa.service;

import java.util.Random;

import com.qa.constants.Constants;

public class SixDigitNumberGen {

	private String number;

	public String generateSixDigitNumber() {

		Random rand = new Random();
		int num = rand.nextInt(Constants.SIX_DIGIT_UPPER_LIMIT) + Constants.SIX_DIGIT_LOWER_LIMIT;
		number = Integer.toString(num);

		return number;

	}

}
