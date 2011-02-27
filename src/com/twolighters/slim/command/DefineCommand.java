package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;

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
	public void execute()
	{
		this.getContext().addReplacement(this.key, this.value);
	}

}
