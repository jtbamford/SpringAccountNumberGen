package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qa.constants.Constants;
import com.qa.domain.AccountNumber;

@Repository
public class SixDigitAccountNumGenRepo {

	@Autowired
	EntityManager em;

	private AccountNumber accNum;

	@Transactional(REQUIRED)
	public String createSixDigitAccNum(String sixDigitAcc) {

		accNum = new AccountNumber();
		accNum.setAccountNumber(sixDigitAcc);
		
		boolean thereAreNoAccountNumbersLikeThisOne =
				em.find(AccountNumber.class, sixDigitAcc) == null;

		if (thereAreNoAccountNumbersLikeThisOne) {
			em.persist(accNum);
			return accNum.getAccountNumber();
		}
		return Constants.ACCOUNT_NOT_CREATED;

	}

}
