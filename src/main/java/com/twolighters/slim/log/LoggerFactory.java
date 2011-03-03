package com.twolighters.slim.log;

public class LoggerFactory
{
	public static ConsoleLogger create()
	{
		String level = System.getProperty("slim.log.level");
		
		if (level == null)
		{
			return ConsoleLogger.newInstance();
		}
		else
		{
			return ConsoleLogger.newInstance(Integer.parseInt(level));
		}
	}
}
