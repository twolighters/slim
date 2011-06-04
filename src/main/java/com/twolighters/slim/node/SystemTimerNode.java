package com.twolighters.slim.node;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.data.Timer;

public class SystemTimerNode extends AbstractNode
{

	public SystemTimerNode(SlimContext context)
	{
		super(context);
	}

	@Override
	public void execute()
	{
		Timer t = new Timer("system");
		getContext().addTimer(t);
	}

}
