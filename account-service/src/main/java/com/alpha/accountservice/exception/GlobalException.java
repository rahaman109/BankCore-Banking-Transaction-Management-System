package com.alpha.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.accountservice.responsedto.ResponseStructure;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleAccountNotFoundException(AccountNotFoundException ex)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				null);
		
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
