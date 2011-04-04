package com.twolighters.slim.command.locator;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextHolder;
import com.twolighters.slim.exceptions.CommandNotLocatedException;

public class CommandLocator extends SlimContextHolder
{

	public CommandLocator(SlimContext context)
	{
		super(context);
	}
	
	public CommandMetadata locate(String token)
	{
		CommandMetadata result =  getContext().getCommand(token);
		if (result != null) return result;
		
		//TODO location process
		
		if (result == null)
		{
			throw new CommandNotLocatedException(token);
		}
		else
		{
			getContext().addCommand(token, result);
			return result;
		}
	}

}
