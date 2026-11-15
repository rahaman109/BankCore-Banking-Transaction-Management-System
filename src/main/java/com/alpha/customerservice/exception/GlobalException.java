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
	public ResponseEntity<ResponseStructure<String>> handleCustomerNotFoundException(CustomerNotFoundException ex)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				null);
		
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerEmailAlreadyExistExcepion.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailAlreadyExistException(CustomerEmailAlreadyExistExcepion ex)
	{
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				null);
		
		return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
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
	
	@ExceptionHandler(CustomerNumberAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> handleCustomerNumberAlreadyExistException(CustomerNumberAlreadyExistException ex)
	{
		ResponseStructure<String> responseStructure = new ResponseStructure<String>(
				HttpStatus.CONFLICT.value(),
				ex.getMessage(),
				null);
		
		return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseStructure<String>> handleValidationException(MethodArgumentNotValidException ex)
	{
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>(
				HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				null);
		
		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST); 
	}
	
}
