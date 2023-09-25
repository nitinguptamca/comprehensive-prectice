package com.comprehensive.practice.designpatterns.structuralDesignPattern.adapter;

public class DecoyDuck implements Quackable {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
