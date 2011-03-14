package com.twolighters.slim.command.builder;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.DefineCommand;

public class DefineCommandBuilder extends CommandBuilder<DefineCommand>
{

	public DefineCommandBuilder(SlimContext context)
	{
		super(context);
	}

	@Override
	public DefineCommand build(String line)
	{
		if (line == null || !line.startsWith("DEFINE"))
		{
			return null;
		}
		
		DefineCommand c = new DefineCommand(getContext());
		int as = line.indexOf(" AS");
		String key = line.substring(7,as);
		String value = line.substring(as+4);
		c.setKey(key);
		c.setValue(value);
		return c;			
	}

}
