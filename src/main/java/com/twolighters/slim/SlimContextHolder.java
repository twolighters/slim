package com.twolighters.slim;

public abstract class SlimContextHolder
{
	private final SlimContext context;
	
	public SlimContextHolder(SlimContext context)
	{
		if (context == null)
		{
			throw new SlimContextNotInstantiatedException("Null context inside Slim operation.");
		}
		
		this.context = context;
	}
	
	public SlimContext getContext()
	{
		return this.context;
	}
	

}
