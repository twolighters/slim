package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;
import com.twolighters.slim.exceptions.CommandInvalidStateException;

@Token(name={"UNZIP"})
public class UnzipCommand extends AbstractCommand
{


	public UnzipCommand(SlimContext context)
	{
		super(context);
	}
	
	private String resource = null;
	@Token(name="TO")
	private String destination = null;
	

	public void setResource(String resource)
	{
		this.resource = resource;
	}

	public String getResource()
	{
		return this.resource;
	}
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}

	public String getDestination()
	{
		return this.destination;
	}
	
	@Override
	public boolean valid()
	{
		return (this.resource != null);
	}
	
	@Override
	public void execute()
	{
		if (!valid())
		{
			throw new CommandInvalidStateException("Resource attribute must be set.");
		}
		
		//TODO unzip it!
	}

}
