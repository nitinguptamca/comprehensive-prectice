package com.comprehensive.practice.designpatterns.structuralDesignPattern.decorator.starbuzz;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

