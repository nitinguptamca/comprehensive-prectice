package com.comprehensive.practice.designpatterns.structuralDesignPattern.observer;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
