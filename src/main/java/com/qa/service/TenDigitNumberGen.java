package com.qa.service;

import java.util.Random;

import com.qa.constants.Constants;

public class TenDigitNumberGen {

	private String number;
	private String number2;
	private String completeNumber;
	
	private Constants constant;

	public String generateTenDigitNumber() {

		Random rand = new Random();
		int num = rand.nextInt(Constants.TEN_DIGIT_UPPER_LIMIT) + Constants.TEN_DIGIT_LOWER_LIMIT;
		int num2 = rand.nextInt(Constants.TEN_DIGIT_EXTRA_DIGIT);

		number = Integer.toString(num);
		number2 = Integer.toString(num2);

		completeNumber = number + number2;

		return completeNumber;

	}

}
