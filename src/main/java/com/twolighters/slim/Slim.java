package com.twolighters.slim;

import com.twolighters.slim.engine.MasterProcessor;

public class Slim
{

	/**
	 * External entry point to Slim.
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		if (args.length == 0)
		{
			run(SlimContext.newInstance());
		}
		else
		{
			run(SlimContext.newInstance(args));
		}

	}
	
	
	/**
	 * Provides a Java runtime entry point to Slim.
	 * @param context
	 */
	public static void run(SlimContext context) throws Exception
	{
		if (context == null)
		{
			throw new SlimContextNotInstantiatedException("Cannot run Slim without a context.");
		}
		
		MasterProcessor processor = new MasterProcessor(context);
		processor.run();
	}
	

}
