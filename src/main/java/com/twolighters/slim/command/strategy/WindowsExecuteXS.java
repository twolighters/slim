package com.twolighters.slim.command.strategy;

import java.io.IOException;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.ExecuteCommand;
import com.twolighters.slim.util.ArrayUtil;

public class WindowsExecuteXS extends AbstractExecuteXS
{

	public WindowsExecuteXS(SlimContext context)
	{
		super(context);
	}

	@Override
	public void execute(ExecuteCommand command)
	{
		//Consider Windows command line execution.
		//http://www.javaworld.com/javaworld/jw-12-2000/jw-1229-traps.html?page=4
		
		String[] windowsCmd = {"cmd.exe", "/C"};
		String[] commandString = ArrayUtil.concatAll(windowsCmd,
				command.getCommand().split(" "));
		executeCore(commandString, command.getWorkingDir(),
				command.getEnv());
	}

}
