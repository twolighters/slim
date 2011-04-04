package com.twolighters.slim.exceptions;

public class CommandNotLocatedException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	
	public CommandNotLocatedException()
	{
		super();
	}

	public CommandNotLocatedException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CommandNotLocatedException(String message)
	{
		super(message);
	}

	public CommandNotLocatedException(Throwable cause)
	{
		super(cause);
	}

}
