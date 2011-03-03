package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.RequiredValidator;

public abstract class AbstractCommand implements Command
{
	private final SlimContext context;
	private boolean executed = false;
	
	protected AbstractCommand(SlimContext context)
	{
		if (context == null)
		{
			throw new IllegalStateException("Null context.");
		}
		
		this.context = context;
	}
	
	protected SlimContext getContext()
	{
		return this.context;
	}
	
	@Override
	public boolean executed()
	{
		return this.executed;
	}
	
	void setExecuted(boolean b)
	{
		this.executed = b;
	}
	
	
	@Override
	public void execute() throws Exception
	{
		RequiredValidator.validate(this);
	}
	
	
	@Override
	public void undo() throws Exception
	{
		if (!this.executed)
		{
			throw new IllegalStateException("Cannot undo command that has not been executed.");
		}
	}
	
}
