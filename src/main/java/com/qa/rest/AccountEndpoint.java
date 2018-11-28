package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.AccountNumberGen;

@RequestMapping("${base_endpoint}")
@RestController
public class AccountEndpoint {

	@Autowired
	private AccountNumberGen service;

	@PostMapping("${create_endpoint}")
	public String createAccount(@PathVariable("accType") int accType) {
		return service.generateAccountNumber(accType);
	}

}
