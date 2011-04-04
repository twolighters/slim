package com.twolighters.slim.command.locator;

import com.twolighters.slim.command.Command;

public class CommandMetadata
{
	private final Class<? extends Command> command;
	
	CommandMetadata(Class<? extends Command> command)
	{
		this.command = command;
	}
	
	public Class<? extends Command> getCommand()
	{
		return this.command;
	}
	
	
}
