package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;
import com.twolighters.slim.exceptions.CommandInvalidStateException;

@Token(name={"DEF","DEFINE"})
public class DefineCommand extends AbstractCommand {

	public DefineCommand(SlimContext context)
	{
		super(context);
	}
	
	private String key;
	private String value;
	
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public boolean valid()
	{
		return (this.key != null && this.value != null);
	}
	
	@Override
	public void execute()
	{
		if (!valid())
		{
			throw new CommandInvalidStateException("Key and Value attributes must be set.");
		}
		
		this.getContext().addReplacement(this.key, this.value);
	}

}
