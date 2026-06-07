package com.helpdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exc)
	{
		ErrorResponse error = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
