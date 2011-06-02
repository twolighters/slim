package com.twolighters.slim.command;

public interface Command
{
	void execute();
	
	void undo();
	
	boolean executed();
	
	/**
	 * Indicates the command state is sufficient for execution. 
	 * @return
	 */
	boolean valid();

}
