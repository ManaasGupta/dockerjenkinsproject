package com.base.jenkinsdockerproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.jenkinsdockerproject.dto.MathRequest;
import com.base.jenkinsdockerproject.dto.MathResponse;
import com.base.jenkinsdockerproject.service.MathService;

@RestController
@RequestMapping("/api")
public class OperationController {
	MathService mathService;

	public OperationController(MathService mathService) {
		this.mathService = mathService;
	}

	@PostMapping("/operation")
	public ResponseEntity<MathResponse> mathOperationResponse(@RequestBody MathRequest request) {
		MathResponse responseEntity = mathService.basicOperationResults(request);
		return new ResponseEntity<>(responseEntity, HttpStatus.OK);
	}
}
