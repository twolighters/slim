package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.GetCommand;

public class GetCommandBuilder extends CommandBuilder<GetCommand>
{

	public GetCommandBuilder(SlimContext context)
	{
		super(context);
	}

	@Override
	public GetCommand build(String line)
	{
		if (line == null
				|| !line.startsWith("GET")
				|| line.equals("GET"))
		{
			return null;
		}
		
		GetCommand c = new GetCommand(getContext());
		String[] tokens = line.split(" ");
		int mode = 0;
		for (String token : tokens)
		{
			if (mode==1)
			{
				c.setResource(token);
				mode=0;
				continue;
			}
			if (mode==2)
			{
				c.setDestination(token);
				mode=0;
				continue;
			}
			if (mode==3)
			{
				c.setCredentials(token);
				mode=0;
				continue;
			}

			
			if (token.equals("GET"))
			{
				mode=1;
			}
			else if (token.equals("TO"))
			{
				mode=2;
			}
			else if (token.equals("AS"))
			{
				mode=3;
			}

		}
		
		return c;
	}

}
