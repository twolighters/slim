package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.EchoCommand;

public class EchoCommandBuilder extends CommandBuilder<EchoCommand>
{

	public EchoCommandBuilder(SlimContext context)
	{
		super(context);
	}

	@Override
	public EchoCommand build(String line)
	{
		if (line == null || !line.startsWith("ECHO"))
		{
			return null;
		}
		
		if (line.equals("ECHO"))
		{
			EchoCommand c = new EchoCommand(getContext());
			c.setText("");
			return c;			
		}		
		else
		{
			EchoCommand c = new EchoCommand(getContext());
			c.setText(line.substring(5));
			return c;			
		}
	}

}
