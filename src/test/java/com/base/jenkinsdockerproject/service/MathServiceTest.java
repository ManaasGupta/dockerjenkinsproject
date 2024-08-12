package com.base.jenkinsdockerproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.base.jenkinsdockerproject.dto.MathRequest;
import com.base.jenkinsdockerproject.dto.MathResponse;

class MathServiceTest {
	private MathService mathService;
	private MathRequest request;

	@BeforeEach
	void setUp() {
		mathService = new MathService();
		request = new MathRequest();
	}

	@Test
	void testAdd() {
		request.setNum1(10.0);
		request.setNum2(5.0);
		double result = mathService.add(request);
		assertEquals(15.0, result);
	}

	@Test
	void testSubtract() {
		request.setNum1(10.0);
		request.setNum2(5.0);
		double result = mathService.subtract(request);
		assertEquals(5.0, result);
	}

	@Test
	void testMultiply() {
		request.setNum1(10.0);
		request.setNum2(5.0);
		double result = mathService.multiply(request);
		assertEquals(50.0, result);
	}

	@Test
	void testDivide() {
		request.setNum1(10.0);
		request.setNum2(2.0);
		double result = mathService.divide(request);
		assertEquals(5.0, result);
	}

	@Test
	void testDivideByZero() {
		request.setNum1(10.0);
		request.setNum2(0.0);
		assertThrows(ArithmeticException.class, () -> mathService.divide(request));
	}

	@Test
	void testExponent() {
		request.setNum1(2.0);
		request.setNum2(3.0);
		double result = mathService.exponent(request);
		assertEquals(8.0, result);
	}

	@Test
	void testBasicOperationResults() {
		request.setNum1(10.0);
		request.setNum2(2.0);
		MathResponse response = mathService.basicOperationResults(request);
		assertEquals(12.0, response.getAddition());
		assertEquals(8.0, response.getSubtraction());
		assertEquals(20.0, response.getMultiplication());
		assertEquals(5.0, response.getDivision());
		assertEquals(100.0, response.getExponent());
	}

}
