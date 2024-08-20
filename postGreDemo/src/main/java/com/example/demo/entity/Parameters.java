package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
	private Double phCurrent1;
	private Double phCurrent2;
	private Double phVoltage1;
	private Double phVoltage2;
	private Double frequency;
	private Double energy;
}
