package com.comprehensive.practice.designpatterns.behavioralPattern.strategy;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
