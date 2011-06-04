package com.twolighters.slim.node;

import java.util.List;

import com.twolighters.slim.SlimContext;

public class CommandLineArgsNode extends AbstractNode
{

	public CommandLineArgsNode(SlimContext context)
	{
		super(context);
	}

	@Override
	public void execute()
	{
		List<String> args = getContext().getArgs();
		
		if (args != null)
		{
			for (int i = 0; i < args.size(); i++)
			{
				getContext().addReplacement(Integer.toString(i), args.get(i));
			}
		}
	}

}
