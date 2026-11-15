package com.alpha.customerservice.exception;

public class CustomerNumberAlreadyExistException extends RuntimeException {

	public CustomerNumberAlreadyExistException(String message)
	{
		super(message);
	}
}
