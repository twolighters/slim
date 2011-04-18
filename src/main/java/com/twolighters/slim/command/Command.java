package com.twolighters.slim.command;

public interface Command
{
	void execute() throws Exception;
	
	void undo() throws Exception;
	
	boolean executed();
	
	/**
	 * Indicates the command state is sufficient for execution. 
	 * @return
	 */
	boolean valid();

}
