package com.twolighters.slim.log;

public class ConsoleLogger extends AbstractLogger
{

	//default to logging at INFO level
	private static int DEFAULT_LEVEL = Level.INFO.getValue();
	
	private ConsoleLogger(int loggingLevel)
	{
		super(loggingLevel);
	}
	
	public static ConsoleLogger newInstance()
	{
		return new ConsoleLogger(DEFAULT_LEVEL);
	}
	
	public static ConsoleLogger newInstance(int loggingLevel)
	{
		return new ConsoleLogger(loggingLevel);
	}

	@Override
	protected void log(String message)
	{
		System.out.println(message);		
	}
	
}
