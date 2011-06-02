package com.twolighters.slim.command.strategy;

import java.io.IOException;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.ExecuteCommand;

public class UnixExecuteXS extends AbstractExecuteXS
{

	public UnixExecuteXS(SlimContext context)
	{
		super(context);
	}

	@Override
	public void execute(ExecuteCommand command)
	{
		executeCore(command.getCommand().split(" "), command.getWorkingDir(),
				command.getEnv());
	}

}
