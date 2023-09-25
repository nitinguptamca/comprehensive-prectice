package com.comprehensive.practice.designpatterns.structuralDesignPattern.decorator.starbuzzWithSizes;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

