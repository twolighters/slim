package com.twolighters.slim.command;

import com.twolighters.slim.Slim;
import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.CommandToken;
import com.twolighters.slim.exceptions.CommandInvalidStateException;

@CommandToken(value="SLIM")
public class SlimCommand extends AbstractCommand
{

	protected SlimCommand(SlimContext context)
	{
		super(context);
	}
	
	private String[] args;
	
	public void setArgs(String[] args)
	{
		this.args = args;
	}
	
	public String[] getArgs()
	{
		return this.args;
	}
	

	@Override
	public boolean valid()
	{
		return this.args != null;
	}
	
	@Override
	public void execute() throws Exception
	{
		
		//TODO
		//"Inherited" property to pass parameters from caller Slim instance.
		
		if (!valid())
		{
			throw new CommandInvalidStateException("Args attribute must be set.");
		}
		
		if (this.args.length == 0)
		{
			Slim.run(SlimContext.newInstance());
		}
		else
		{
			Slim.run(SlimContext.newInstance(this.args));
		}
	}

}
