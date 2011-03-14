package com.twolighters.slim;

/**
 * This exception is thrown when a new SlimContext has not
 * been instantiated before attempting to run Slim.
 * 
 * @author Mac
 *
 */
public class SlimContextNotInstantiatedException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public SlimContextNotInstantiatedException()
	{
		super();
	}

	public SlimContextNotInstantiatedException(String s)
	{
		super(s);
	}

	public SlimContextNotInstantiatedException(Throwable cause)
	{
		super(cause);
	}

	public SlimContextNotInstantiatedException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
