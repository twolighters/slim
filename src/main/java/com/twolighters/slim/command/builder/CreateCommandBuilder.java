package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.CreateCommand;

public class CreateCommandBuilder extends CommandBuilder<CreateCommand>
{
	public CreateCommandBuilder(SlimContext context)
	{
		super(context);
	}
	

	@Override
	public CreateCommand build(String line)
	{
		if (line == null || line.equals("CREATE") ||
				(!line.startsWith("CREATE DIR") && !line.startsWith("CREATE FILE")) )
		{
			return null;
		}
		
		CreateCommand c = new CreateCommand(getContext());
		if (line.startsWith("CREATE DIR"))
		{
			c.setDirectory(line.substring(11));
		}
		else //FILE
		{
			c.setFile(line.substring(12));
		}
		return c;
	}
}
