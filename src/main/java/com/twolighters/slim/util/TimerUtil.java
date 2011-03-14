package com.twolighters.slim.util;

public class TimerUtil
{
	private static long START = 0;
	
	/**
	 * This will always restart the
	 * timer by replacing the value
	 * of the START static field.
	 */
	public static void start()
	{
		START = System.currentTimeMillis();
	}
	
	public static long elapsedTime()
	{
		return System.currentTimeMillis() - START;
	}
	
	
}
