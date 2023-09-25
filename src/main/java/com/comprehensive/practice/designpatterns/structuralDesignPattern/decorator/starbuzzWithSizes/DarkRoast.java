package com.comprehensive.practice.designpatterns.structuralDesignPattern.decorator.starbuzzWithSizes;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

