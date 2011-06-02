package com.twolighters.slim.exceptions;

/**
 * This exception can occur while executing an individual command.
 * 
 * @author Mac
 */
public class CommandExecutionException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public CommandExecutionException()
	{
		super();
	}

	public CommandExecutionException(String message)
	{
		super(message);
	}

	public CommandExecutionException(Throwable cause)
	{
		super(cause);
	}

	public CommandExecutionException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
