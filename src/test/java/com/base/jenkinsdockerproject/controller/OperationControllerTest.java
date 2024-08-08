package com.base.jenkinsdockerproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.base.jenkinsdockerproject.dto.MathRequest;
import com.base.jenkinsdockerproject.dto.MathResponse;
import com.base.jenkinsdockerproject.service.MathService;

class OperationControllerTest {

	  @InjectMocks
	    private OperationController operationController;

	    @Mock
	    private MathService mathService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testMathOperationResponse() {
	        MathRequest request = new MathRequest();
	        request.setNum1(10.0);
	        request.setNum2(5.0);

	        MathResponse response = new MathResponse();
	        response.setAddition(15.0);
	        response.setSubtraction(5.0);
	        response.setMultiplication(50.0);
	        response.setDivision(2.0);
	        response.setExponent(1000.0);

	        when(mathService.basicOperationResults(request)).thenReturn(response);

	        ResponseEntity<MathResponse> responseEntity = operationController.mathOperationResponse(request);
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(response, responseEntity.getBody());
	    }

}
