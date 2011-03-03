package com.twolighters.slim.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil
{
	public static String now(String format)
	{
		return format(Calendar.getInstance(), format);
	}
	
	public static String format(Calendar cal, String format)
	{
		return format(cal.getTime(), format);
	}
	
	public static String format(Date date, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
