package com.alpha.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.customerservice.responseDto.ResponseStructure;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseStructure<String> handleCustomerNotFoundException(CustomerNotFoundException ex)
	{
		return new ResponseStructure<>(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				null);
	}
	
	@ExceptionHandler(CustomerEmailAlreadyExistExcepion.class)
	public ResponseStructure<String> handleEmailAlreadyExistException(CustomerEmailAlreadyExistExcepion ex)
	{
		return new ResponseStructure<>(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				null);
	}
	
	@ExceptionHandler(CustomerNumberAlreadyExistException.class)
	public ResponseStructure<String> handleCustomerNumberAlreadyExistException(CustomerNumberAlreadyExistException ex)
	{
		return new ResponseStructure<>(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				null);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseStructure<String> handleValidationException(MethodArgumentNotValidException ex)
	{
		return new ResponseStructure<>(
				HttpStatus.BAD_REQUEST.value(),
				"Validation failed",
				null);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handleConstraintViolation(
	        ConstraintViolationException ex) {

	    ResponseStructure<String> response = new ResponseStructure<>(
	            HttpStatus.BAD_REQUEST.value(),
	            "Validation failed",
	            null
	    );

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
