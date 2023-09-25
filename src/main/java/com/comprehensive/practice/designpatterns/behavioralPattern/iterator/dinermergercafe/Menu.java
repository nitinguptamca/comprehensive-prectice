package com.comprehensive.practice.designpatterns.behavioralPattern.iterator.dinermergercafe;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
