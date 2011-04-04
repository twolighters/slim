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
	
	/**
	 * Splits a String into a key and value pair.
	 * 
	 * The split will happen at the FIRST instance of the delimiter.
	 * If there is no instance of the delimiter, null is returned.
	 * 
	 * @param input
	 * @param delimiter
	 * @return
	 */
	public static KeyValue splitKeyAndValue(String input, String delimiter)
	{	
		int index = input.indexOf(delimiter);
		if (index < 0)  return null;
		
		String[] s = input.split(delimiter, 2);
			
		return new KeyValue(s[0],s[1]);
	}
	
	public static class KeyValue
	{
		private final String key, value;
		public KeyValue(String key, String value)
		{
			this.key = key;
			this.value = value;
		}
		
		public String getKey()
		{
			return this.key;
		}
		
		public String getValue()
		{
			return this.value;
		}
	}
}
