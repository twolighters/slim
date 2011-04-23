package com.twolighters.slim.node;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextHolder;

public abstract class AbstractNode extends SlimContextHolder
	implements Node
{

	public AbstractNode(SlimContext context)
	{
		super(context);
	}

}
