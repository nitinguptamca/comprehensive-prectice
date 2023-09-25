package com.comprehensive.practice.designpatterns.behavioralPattern.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
