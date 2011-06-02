package com.twolighters.slim.exceptions;

/**
 * This type of exception can occur when loading a Slim script from
 * its source (file, URL, etc.)
 * 
 * @author Mac
 */
public class ScriptLoadException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public ScriptLoadException()
	{
		super();
	}

	public ScriptLoadException(String message)
	{
		super(message);
	}

	public ScriptLoadException(Throwable cause)
	{
		super(cause);
	}

	public ScriptLoadException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
