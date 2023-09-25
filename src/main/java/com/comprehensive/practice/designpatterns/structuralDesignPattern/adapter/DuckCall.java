package com.comprehensive.practice.designpatterns.structuralDesignPattern.adapter;

public class DuckCall implements Quackable {
	public void quack() {
		System.out.println("Kwak");
	}
}
