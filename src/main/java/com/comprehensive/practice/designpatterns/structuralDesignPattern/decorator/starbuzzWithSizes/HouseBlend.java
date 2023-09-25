package com.comprehensive.practice.designpatterns.structuralDesignPattern.decorator.starbuzzWithSizes;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}
}

