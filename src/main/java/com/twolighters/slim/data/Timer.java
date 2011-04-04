package com.twolighters.slim.data;

public class Timer
{
	
	private final String name;
	private final long startTime = System.currentTimeMillis();
	
	public Timer(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public long getElapsedTime()
	{
		return System.currentTimeMillis() - this.startTime;
	}
	
	
}
