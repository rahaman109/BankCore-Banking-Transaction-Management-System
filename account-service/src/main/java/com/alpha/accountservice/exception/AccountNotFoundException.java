package com.alpha.accountservice.exception;

public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String message) {
		super(message);
	}
}
