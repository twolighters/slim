package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;
import com.twolighters.slim.command.strategy.ExecuteStrategy;

@Token(name={"EXEC","EXECUTE"})
public class ExecuteCommand extends AbstractCommand
{

	private final ExecuteStrategy<ExecuteCommand> strategy;
	
	public ExecuteCommand(SlimContext context, ExecuteStrategy<ExecuteCommand> strategy)
	{
		super(context);
		this.strategy = strategy;
	}
	
	@Token(name="COMMAND")
	private String command = null;
	private String[] env = null;
	private String workingDir = null;
	
	public void setCommand(String command)
	{
		this.command = command;
	}
	
	public String getCommand()
	{
		return this.command;
	}

	public void setEnv(String[] env)
	{
		this.env = env;
	}
	
	public String[] getEnv()
	{
		return this.env;
	}
	
	public void setWorkingDir(String workingDir)
	{
		this.workingDir = workingDir;
	}
	
	public String getWorkingDir()
	{
		return this.workingDir;
	}
	
	@Override
	public boolean valid()
	{
		//TODO
		return true;
	}
	
	@Override
	public void execute()
	{
		this.strategy.execute(this);
	}
	


}
