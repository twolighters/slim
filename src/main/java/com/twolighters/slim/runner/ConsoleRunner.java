package com.twolighters.slim.runner;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.engine.MasterProcessor;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;

public class ConsoleRunner implements Runner
{

	@Override
	public RunResult run(SlimContext context)
	{
		if (context == null)
		{
			throw new ContextNotInstantiatedException("Cannot run Slim without a context.");
		}
		
		MasterProcessor processor = new MasterProcessor(context);
		processor.run();
		
		return null; //TODO result object
	}

}
