package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.util.CalendarUtil;
import com.twolighters.slim.util.SysUtil;

public class ReplacementStrategy extends AbstractEngine
{
	
	private static String DELIMITER = ":";
	private static String LINE_SEPARATOR = System.getProperty("line.separator");
	
	protected ReplacementStrategy(SlimContext context)
	{
		super(context);
	}

	/**
	 * Returns null if no replacement found.
	 * @param token
	 * @return
	 */
	public String replace(String token)
	{
		if (token == null || token.equals(""))
		{
			return null;
		}
		
		int dIdx = token.indexOf(DELIMITER);
		if (dIdx>0 && dIdx<token.length()-1)
		{
			String label = token.substring(0, dIdx);
			SpecialReplacement rep = SpecialReplacement.valueOf(label);
			String key = token.substring(dIdx+1);
			return processSpecialReplacement(rep, key);
		}
		
		
		/*
		 * If it falls through to here, treat token as user-defined.
		 */
		return getContext().getReplacement(token);
	}
	
	private String processSpecialReplacement(SpecialReplacement rep, String key)
	{
		switch (rep)
		{
		case ENV:
			return System.getenv(key);
		case SYSPROP:
			return System.getProperty(key);
		case NOW:
			return CalendarUtil.now(key);
		case LIST:
			return processListReplacement(key);
		}
		
		return null;
	}
	
	private String processListReplacement(String key)
	{
		String result = null;
		
		if (key.equals("ENV"))
		{
			result = SysUtil.listEnv();
		}
		else if (key.equals("SYSPROP"))
		{
			result = SysUtil.listSysProp();
		}
		else if (key.equals("USER"))
		{
			StringBuilder sb = new StringBuilder();
			for (String k : getContext().getReplacementKeys())
			{
				String v = getContext().getReplacement(k);
				sb.append(k).append("=").append(v).append(LINE_SEPARATOR);
			}
			result = sb.toString();
		}
		
		return result;
	}
}
