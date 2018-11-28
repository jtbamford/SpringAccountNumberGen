package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qa.constants.Constants;
import com.qa.domain.AccountNumber;

@Repository
public class TenDigitAccountNumGenRepo {

	@Autowired
	EntityManager em;

	private AccountNumber accNum;

	@Transactional(REQUIRED)
	public String createTenDigitAccNum(String tenDigitAcc) {

		accNum = new AccountNumber();
		accNum.setAccountNumber(tenDigitAcc);
		
		boolean thereAreNoAccountNumbersLikeThisOne =
				em.find(AccountNumber.class, tenDigitAcc) == null;

		if (thereAreNoAccountNumbersLikeThisOne) {
			em.persist(accNum);
			return accNum.getAccountNumber();
		}
		return Constants.ACCOUNT_NOT_CREATED;
	}

}
