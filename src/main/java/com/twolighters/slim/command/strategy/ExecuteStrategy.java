package com.twolighters.slim.command.strategy;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextHolder;
import com.twolighters.slim.command.Command;

/**
 * Basic skeleton of an execute strategy, to be used by
 * a specific command type.  The Slim command forms the
 * "context" of the strategy as defined by Go4 Strategy
 * pattern.  Additionally, these strategies have access
 * to the global SlimContext.
 * 
 * Naming note: subclasses of ExecuteStrategy will
 * conventionally use the suffix "XS" as shorthand for
 * "ExecuteStrategy."
 * 
 * @author Mac
 *
 * @param <T>
 */
public abstract class ExecuteStrategy<T extends Command> extends SlimContextHolder
{

	public ExecuteStrategy(SlimContext context)
	{
		super(context);
	}
	
	/**
	 * Go4 Strategy pattern discusses the option of passing
	 * the context to the Strategy, which is what we do
	 * in this method signature.  The Slim command is the
	 * local context for an execution strategy.
	 *  
	 * @param command
	 */
	public abstract void execute(T command);

}