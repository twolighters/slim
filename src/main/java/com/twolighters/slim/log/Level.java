package com.twolighters.slim.log;

public enum Level
{
	ALWAYS(-1),
	ERROR(0),
	INFO(1),
	DEBUG(2),
	TRACE(3);
	
	private int value;
	
	private Level(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
