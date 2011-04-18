package com.twolighters.slim.exceptions;

public class CommandInvalidStateException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	
	public CommandInvalidStateException()
	{
		super();
	}

	public CommandInvalidStateException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CommandInvalidStateException(String message)
	{
		super(message);
	}

	public CommandInvalidStateException(Throwable cause)
	{
		super(cause);
	}

}
