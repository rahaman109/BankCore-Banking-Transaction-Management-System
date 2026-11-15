package com.alpha.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message)
	{
		super(message);
	}
}
