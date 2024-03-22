package com.banksystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
 
@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value=InsufficientBalanceException.class)
		public ResponseEntity<Object>exception(InsufficientBalanceException exception)
		{
		  	return new ResponseEntity<>("Insufficient balance.",HttpStatus.NOT_ACCEPTABLE);
		}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object>exception(UserNotFoundException exception)
	{
	  	return new ResponseEntity<>("User id not found.",HttpStatus.NOT_ACCEPTABLE);
	}
}
