package com.twolighters.slim.runner;

import java.util.ArrayList;
import java.util.List;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;
import com.twolighters.slim.node.CommandLineArgsNode;
import com.twolighters.slim.node.LineProcessorNode;
import com.twolighters.slim.node.Node;
import com.twolighters.slim.node.ScriptLoaderNode;
import com.twolighters.slim.node.SystemTimerNode;
import com.twolighters.slim.node.VersionPropertyNode;

public class AbstractRunner implements Runner
{

	@Override
	public RunResult run(SlimContext context)
	{
		if (context == null)
		{
			throw new ContextNotInstantiatedException("Cannot run Slim without a context.");
		}
		
		/*
		 * TODO
		 * 
		 * The following is a placeholder until nodus is implemented.
		 * 
		 * Not to mention that this kind of work probably
		 * shouldn't be done in an AbstractRunner.
		 * 
		 */
		
		List<Node> list = new ArrayList<Node>();
		list.add(new SystemTimerNode(context));
		list.add(new VersionPropertyNode(context));
		list.add(new CommandLineArgsNode(context));
		list.add(new ScriptLoaderNode(context));
		list.add(new LineProcessorNode(context));
		
		for (Node n : list)
		{
			n.execute();
		}
		
		
		return null;
	}

}
