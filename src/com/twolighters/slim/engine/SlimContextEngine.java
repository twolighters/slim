package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;

public class SlimContextEngine extends AbstractEngine
{

	
	/**
	 * This might be invoked internally/externally when a custom-set
	 * SlimContext needs to be passed.
	 * 
	 * @param context
	 */
	public SlimContextEngine(SlimContext context)
	{
		super(context);
	}
	
	public void run()
	{
		//TODO validate SlimContext and set all default settings.
	}

}
