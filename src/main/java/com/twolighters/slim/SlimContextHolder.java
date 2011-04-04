package com.twolighters.slim;

import com.twolighters.slim.exceptions.ContextNotInstantiatedException;

public abstract class SlimContextHolder
{
	private final SlimContext context;
	
	public SlimContextHolder(SlimContext context)
	{
		if (context == null)
		{
			throw new ContextNotInstantiatedException("Null context inside Slim operation.");
		}
		
		this.context = context;
	}
	
	public SlimContext getContext()
	{
		return this.context;
	}
	

}
