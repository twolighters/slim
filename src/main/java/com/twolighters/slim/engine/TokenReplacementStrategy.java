package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.util.CalendarUtil;

public class TokenReplacementStrategy extends AbstractEngine
{
	private static String ENV_PREFIX = "ENV:";
	private static String SYSPROP_PREFIX = "SYS:";
	private static String NOW_PREFIX = "NOW:";
	
	protected TokenReplacementStrategy(SlimContext context)
	{
		super(context);
	}

	public String replace(String token)
	{
		if (token==null
				|| token.equals(ENV_PREFIX)
				|| token.equals(SYSPROP_PREFIX)
				|| token.equals(NOW_PREFIX))
		{
			return null;
		}
		
		if (token.startsWith(ENV_PREFIX))
		{
			return System.getenv(token.substring(4));
		}
		
		if (token.startsWith(SYSPROP_PREFIX))
		{
			return System.getProperty(token.substring(4));
		}

		if (token.startsWith(NOW_PREFIX))
		{
			return CalendarUtil.now(token.substring(4));
		}
		
		/*
		 * If it falls through to here, treat token as user-defined.
		 */
		return getContext().getReplacement(token);
	}
}
