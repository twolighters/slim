package com.twolighters.slim.exceptions;

/**
 * This exception is thrown when a new SlimContext has not
 * been instantiated before attempting to run Slim.
 * 
 * @author Mac
 *
 */
public class ContextNotInstantiatedException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public ContextNotInstantiatedException()
	{
		super();
	}

	public ContextNotInstantiatedException(String s)
	{
		super(s);
	}

	public ContextNotInstantiatedException(Throwable cause)
	{
		super(cause);
	}

	public ContextNotInstantiatedException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
