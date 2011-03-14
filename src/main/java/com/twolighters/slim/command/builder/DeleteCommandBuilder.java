package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.DeleteCommand;

public class DeleteCommandBuilder extends CommandBuilder<DeleteCommand>
{

	public DeleteCommandBuilder(SlimContext context)
	{
		super(context);
	}

	@Override
	public DeleteCommand build(String line)
	{
		if (line == null
				|| !line.startsWith("DELETE")
				|| line.equals("DELETE"))
		{
			return null;
		}
		
		DeleteCommand c = new DeleteCommand(getContext());
		c.setResource(line.substring(7));
		return c;			
	}

}
