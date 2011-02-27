package com.twolighters.slim.command;

public interface Command
{
	void execute() throws Exception;
	
	void undo() throws Exception;
	
	boolean executed();

}
