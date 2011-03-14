package com.twolighters.slim;

/**
 * This type of exception can occur when parsing Slim script.
 * 
 * @author Mac
 */
public class SlimScriptSyntaxException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public SlimScriptSyntaxException()
	{
		super();
	}

	public SlimScriptSyntaxException(String message)
	{
		super(message);
	}

	public SlimScriptSyntaxException(Throwable cause)
	{
		super(cause);
	}

	public SlimScriptSyntaxException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
