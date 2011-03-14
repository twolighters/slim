package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextHolder;
import com.twolighters.slim.command.Command;

public abstract class CommandBuilder<T extends Command> extends SlimContextHolder
{	
	public CommandBuilder(SlimContext context)
	{
		super(context);
	}

	public abstract T build(String line);
}
