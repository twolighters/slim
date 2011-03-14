package com.twolighters.slim.log;

public abstract class AbstractLogger
{
	private int loggingLevel = -2; //this value isn't valid; the real value
	                               //must be set in constructor.
	
	public AbstractLogger(int loggingLevel)
	{
		this.loggingLevel = loggingLevel;
	}
	
	public void log(Level requestLevel, String message)
	{
		if (this.loggingLevel > requestLevel.getValue())
		{
			log(message);
		}
	}
	
	/**
	 * This method does the real work of logging.
	 * @param message
	 */
	protected abstract void log(String message);
	
	public void always(String message)
	{
		log(Level.ALWAYS, message);
	}
	
	public void error(String message)
	{
		log(Level.ERROR, message);
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
