package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.ExecuteCommand;
import com.twolighters.slim.command.strategy.ExecuteStrategy;
import com.twolighters.slim.command.strategy.UnixExecuteXS;
import com.twolighters.slim.command.strategy.WindowsExecuteXS;
import com.twolighters.slim.exceptions.ScriptSyntaxException;

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
		
		//creation pattern for strategies may be annotation-driven later.
		ExecuteStrategy<ExecuteCommand> xs = getContext().isWindowsOS() ?
				new WindowsExecuteXS(getContext()) :
				new UnixExecuteXS(getContext());
		
		ExecuteCommand c = new ExecuteCommand(getContext(), xs);
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
					c.setCommand(sub);
					mode=0;
					continue;
				}
				else if (mode == 1)
				{
					c.setCommand(token);
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
				throw new ScriptSyntaxException("Unexpected token: " + token);
			}

		}
		
		return c;
	}
	
}
