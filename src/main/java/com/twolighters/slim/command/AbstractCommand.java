package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextHolder;
import com.twolighters.slim.command.annotations.RequiredValidator;

public abstract class AbstractCommand extends SlimContextHolder implements Command
{
	private boolean executed = false;
	
	protected AbstractCommand(SlimContext context)
	{
		super(context);
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
	public void execute()
	{
		RequiredValidator.validate(this);
	}
	
	
	@Override
	public void undo()
	{
		if (!this.executed)
		{
			throw new IllegalStateException("Cannot undo command that has not been executed.");
		}
	}
	
}
