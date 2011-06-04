package com.twolighters.slim;

import com.twolighters.slim.runner.ConsoleRunner;
import com.twolighters.slim.runner.RunResult;
import com.twolighters.slim.runner.Runner;

public class Slim
{

	/**
	 * External entry point to Slim.  Defaults to
	 * ConsoleRunner runner.
	 * 
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
	 * Provides a Java runtime entry point to Slim,
	 * defaulting to ConsoleRunner runner.
	 * 
	 * Same as Slim.run(new ConsoleRunner(), context)
	 * 
	 * @param context
	 */
	public static RunResult run(SlimContext context)
	{		
		return Slim.run(new ConsoleRunner(), context);
	}
	
	/**
	 * Provides a Java runtime entry point to Slim.
	 * @param runner  client-specified runner.
	 * @param context
	 */
	public static RunResult run(Runner runner, SlimContext context)
	{
		return runner.run(context);
	}
	

}
