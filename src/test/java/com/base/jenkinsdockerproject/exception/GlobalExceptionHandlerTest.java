package com.base.jenkinsdockerproject.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

class GlobalExceptionHandlerTest {

	 private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

	    @Test
	    void testNullPointerExceptionHandler() {
	        NullPointerException ex = new NullPointerException();
	        ResponseEntity<String> response = exceptionHandler.nullPointerExceptionHand(ex);
	        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	        assertEquals("Invalid/Null Parameter are passed", response.getBody());
	    }

	    @Test
	    void testGlobalExceptionHandler() {
	        Exception ex = new Exception();
	        ResponseEntity<String> response = exceptionHandler.globalExceptionHand(ex);
	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	        assertEquals("Internal Server Error", response.getBody());
	    }

	    @Test
	    void testHttpMessageNotReadableExceptionHandler() {
	        @SuppressWarnings("deprecation")
			HttpMessageNotReadableException ex = new HttpMessageNotReadableException("Message not readable");
	        ResponseEntity<String> response = exceptionHandler.httpMessageNotReadableExceptionHandler(ex);
	        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	        assertEquals("Parameter value is not parsable", response.getBody());
	    }

	    @Test
	    void testArithmeticExceptionHandler() {
	        ArithmeticException ex = new ArithmeticException("Division by zero");
	        ResponseEntity<String> response = exceptionHandler.arithmeticExceptionHandler(ex);
	        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	        assertEquals("Divisor is ZERO. Division by zero is not allowed", response.getBody());
	    }

}
