package com.twolighters.slim.util;

public class StringUtil
{
	public static String capitalize(String s)
	{
		if (s == null || s.equals(""))
			return s;
		
		if (s.length() == 1)
			return s.toUpperCase();
		
		String cap = s.substring(0, 1).toUpperCase();
		cap += s.substring(1);
		return cap;
	}
	
	
	/**
	 * Returns part of URL after last /
	 * @return
	 */
	public static String urlResourceName(String url)
	{
		if (url.lastIndexOf('/') == -1)
		{
			return url;
		}
		else
		{
			return url.substring(url.lastIndexOf('/') + 1);
		}
	}
}
