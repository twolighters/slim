package com.twolighters.slim.exceptions;

/**
 * This type of exception can occur when parsing Slim script.
 * 
 * @author Mac
 */
public class ScriptSyntaxException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public ScriptSyntaxException()
	{
		super();
	}

	public ScriptSyntaxException(String message)
	{
		super(message);
	}

	public ScriptSyntaxException(Throwable cause)
	{
		super(cause);
	}

	public ScriptSyntaxException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
