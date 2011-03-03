package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;

public class AbstractEngine
{
	private final SlimContext context;
	
	protected AbstractEngine(SlimContext context)
	{
		if (context == null)
		{
			throw new IllegalStateException("Null context.");
		}
		
		this.context = context;
	}
	
	protected SlimContext getContext()
	{
		return this.context;
	}
}
