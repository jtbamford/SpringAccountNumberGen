package com.qa.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.constants.Constants;
import com.qa.domain.AccountNumber;
import com.qa.repository.EightDigitAccountNumGenRepo;
import com.qa.repository.SixDigitAccountNumGenRepo;
import com.qa.repository.TenDigitAccountNumGenRepo;

@Service
public class AccountNumberGen {

	private AccountNumber accNum;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private SixDigitAccountNumGenRepo sixDigitAccRepo;

	@Autowired
	private EightDigitAccountNumGenRepo eightDigitAccRepo;

	@Autowired
	private TenDigitAccountNumGenRepo tenDigitAccRepo;

	public String generateAccountNumber(int accType) {

		switch (accType) {
		case 0:
			accNum = new AccountNumber(new LetterGen().generateLetter() + new SixDigitNumberGen().generateSixDigitNumber());
			return sixDigitAccRepo.createSixDigitAccNum(accNum.getAccountNumber());
			
		case 1:
			accNum = new AccountNumber(new LetterGen().generateLetter() + new EightDigitNumberGen().generateEightDigitNumber());
			return eightDigitAccRepo.createEightDigitAccNum(accNum.getAccountNumber());

		case 2:
			accNum = new AccountNumber(new LetterGen().generateLetter() + new TenDigitNumberGen().generateTenDigitNumber());
			return tenDigitAccRepo.createTenDigitAccNum(accNum.getAccountNumber());

		default:
			return Constants.NOT_VALID_ACCOUNT_TYPE;

		}

	}

	public void setEightDigRepo(EightDigitAccountNumGenRepo repo) {
		eightDigitAccRepo = repo;
	}

	public void setSixDigitAccRepo(SixDigitAccountNumGenRepo sixDigitAccRepo) {
		this.sixDigitAccRepo = sixDigitAccRepo;
	}

	public void setTenDigitAccRepo(TenDigitAccountNumGenRepo tenDigitAccRepo) {
		this.tenDigitAccRepo = tenDigitAccRepo;
	}

}
