package com.comprehensive.practice.designpatterns.behavioralPattern.iterator.dinermergeri;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
