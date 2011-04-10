package com.twolighters.slim.util;

import java.util.Map;
import java.util.Properties;

public class SysUtil
{
	private static String LINE_SEPARATOR = System.getProperty("line.separator");
	
	
	public static String listEnv()
	{
		String result = null;
		
		Map<String,String> map = System.getenv();
		if (map!=null)
		{
			StringBuilder sb = new StringBuilder();
			for (String k : map.keySet())
			{
				String v = System.getenv(k);
				sb.append(k).append("=").append(v).append(LINE_SEPARATOR);
			}
			result = sb.toString();
		}
		
		return result;
	}
	
	public static String listSysProp()
	{
		String result = null;
		
		Properties p = System.getProperties();
		if (p!=null)
		{
			StringBuilder sb = new StringBuilder();
			for (Object o : p.keySet())
			{
				String k = (String) o;
				String v = p.getProperty(k);
				sb.append(k).append("=").append(v).append(LINE_SEPARATOR);
			}
			result = sb.toString();
		}
		
		return result;
	}
	
	
	public static boolean isWindowsOS()
	{
		return System.getProperty("os.name").startsWith("Windows");
	}
}
