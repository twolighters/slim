package com.twolighters.slim.log;

public class ConsoleLogger
{

	private static int DEFAULT_LEVEL = 1; //default to logging at PROD level
	private int userLevel = -2; //this value wouldn't be valid; must be set in constructor.
	
	private ConsoleLogger(int userLevel)
	{
		this.userLevel = userLevel;
	}
	
	public static ConsoleLogger newInstance()
	{
		return new ConsoleLogger(DEFAULT_LEVEL);
	}
	
	public static ConsoleLogger newInstance(int userLevel)
	{
		return new ConsoleLogger(userLevel);
	}

	
	public void log(Level requestLevel, String message)
	{
		if (this.userLevel > requestLevel.getValue())
		{
			System.out.println(message);
		}
	}
	
	public void always(String message)
	{
		log(Level.ALWAYS, message);
	}
	
	public void prod(String message)
	{
		log(Level.PROD, message);
	}
	
	public void info(String message)
	{
		log(Level.INFO, message);
	}

	public void debug(String message)
	{
		log(Level.DEBUG, message);
	}

	public void trace(String message)
	{
		log(Level.TRACE, message);
	}	
	
}
