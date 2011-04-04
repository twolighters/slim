package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;

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
	public void execute()
	{
		//TODO unzip it!
	}

}
