package com.qa.domain;

import javax.persistence.*;

@Entity
public class AccountNumber {
	
	@Id
	private String accountNumber;

	public AccountNumber() {
	}

	public AccountNumber(String accountCreated) {
		accountNumber=accountCreated;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	

}
