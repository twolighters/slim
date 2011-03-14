package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimScriptSyntaxException;
import com.twolighters.slim.command.ExecuteCommand;

public class ExecuteCommandBuilder extends CommandBuilder<ExecuteCommand>
{

	public ExecuteCommandBuilder(SlimContext context)
	{
		super(context);
	}

	@Override
	public ExecuteCommand build(String line)
	{
		if (line == null
				|| !line.startsWith("EXEC")
				|| line.equals("EXEC"))
		{
			return null;
		}
		
		ExecuteCommand c = new ExecuteCommand(getContext());
		String[] tokens = line.split(" ");
		int mode = 0;
		String sub = "";
		for (String token : tokens)
		{
			if ( mode%10 == 1)
			{
				if (mode == 1 && token.startsWith("\""))
				{
					mode += 10;
					sub += token.substring(1);
					continue;
				}
				else if (mode == 11 && token.endsWith("\""))
				{
					sub += " " + token.substring(0,token.length()-1);
					c.setExecutable(sub);
					mode=0;
					continue;
				}
				else if (mode == 1)
				{
					c.setExecutable(token);
					mode=0;
					continue;
				}
				else
				{
					sub += " " + token;
					continue;
				}
			}
			if (mode==2)
			{
				String[] env = token.split(",");
				c.setEnv(env);
				mode=0;
				continue;
			}
			if (mode==3)
			{
				c.setWorkingDir(token);
				mode=0;
				continue;
			}

			
			if (token.equals("EXEC"))
			{
				mode=1;
			}
			else if (token.equals("ENV"))
			{
				mode=2;
			}
			else if (token.equals("IN"))
			{
				mode=3;
			}
			else
			{
				throw new SlimScriptSyntaxException("Unexpected token: " + token);
			}

		}
		
		return c;
	}
	
}
