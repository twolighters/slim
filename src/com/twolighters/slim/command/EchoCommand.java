package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;

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
	public void execute()
	{
		getContext().getLogger().always(this.text);
	}

}
