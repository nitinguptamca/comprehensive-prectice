package com.comprehensive.practice.designpatterns.behavioralPattern.strategy;

public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
