package com.base.jenkinsdockerproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MathRequest {
	@JsonProperty("NUMBER1")
	private Double num1;
	@JsonProperty("NUMBER2")
	private Double num2;
}
