package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.Command;

public class MasterProcessor extends AbstractEngine
{

	public MasterProcessor(SlimContext context)
	{
		super(context);
	}
	
	public void run() throws Exception
	{
		ScriptLoaderEngine sle = new ScriptLoaderEngine(getContext());
		sle.run();
		
		LineProcessor lineProcessor = new LineProcessor(getContext());
		for (String line : getContext().getRawScript())
		{
			Command c = lineProcessor.process(line);
			if (c==null)
			{
				getContext().getLogger().trace("command returned: null");
			}
			else
			{
				getContext().getLogger().trace("command returned: " + c.getClass().getName());
				c.execute();	
			}
			
		}
		
	}
	
}
