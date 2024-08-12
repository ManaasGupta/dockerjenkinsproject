package com.base.jenkinsdockerproject.service;

import org.springframework.stereotype.Service;

import com.base.jenkinsdockerproject.dto.MathRequest;
import com.base.jenkinsdockerproject.dto.MathResponse;

@Service
public class MathService {
	
	public double add(MathRequest request) {
		return request.getNum1() + request.getNum2();
	}

	public double subtract(MathRequest request) {
		return request.getNum1() - request.getNum2();
	}

	public double multiply(MathRequest request) {
		return request.getNum1() * request.getNum2();
	}

	public double divide(MathRequest request){
		if (request.getNum2() == 0) {
			throw new ArithmeticException("Division by zero is not allowed.");
		}
		return request.getNum1() / request.getNum2();
	}
	
	public double exponent(MathRequest request) {
		return Math.pow(request.getNum1(), request.getNum2());
	}
	
	public MathResponse basicOperationResults(MathRequest request){
		MathResponse response = new MathResponse(); 
		response.setAddition(add(request));
		response.setSubtraction(subtract(request));
		response.setMultiplication(multiply(request));
		response.setDivision(divide(request));
		response.setExponent(exponent(request));
		return response;
	}
}
