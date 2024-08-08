package com.base.jenkinsdockerproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerExceptionHand(NullPointerException nullPointerException){
		return new ResponseEntity<>("Invalid/Null Parameter are passed",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalExceptionHand(Exception ex){
		return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex){
		return new ResponseEntity<>("Parameter value is not parsable",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> arithmeticExceptionHandler(ArithmeticException ex){
		return new ResponseEntity<>("Divisor is ZERO. Division by zero is not allowed",HttpStatus.BAD_REQUEST);
	}
}
