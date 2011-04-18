package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;
import com.twolighters.slim.exceptions.CommandInvalidStateException;

@Token(name="ECHO")
public class EchoCommand extends AbstractCommand {

	public EchoCommand(SlimContext context)
	{
		super(context);
	}
	
	
	private String text = null;
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	@Override
	public boolean valid()
	{
		return (this.text != null);
	}
	
	
	@Override
	public void execute()
	{
		if (!valid())
		{
			throw new CommandInvalidStateException("Text attribute must be set.");
		}
		
		getContext().getLogger().always(this.text);
	}

}
