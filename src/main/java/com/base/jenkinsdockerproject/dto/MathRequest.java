package com.base.jenkinsdockerproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class MathRequest {
	@JsonProperty("NUMBER1")
	private Double num1;
	@JsonProperty("NUMBER2")
	private Double num2;
}
