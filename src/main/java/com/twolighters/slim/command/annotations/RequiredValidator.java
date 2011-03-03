package com.twolighters.slim.command.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.twolighters.slim.command.Command;
import com.twolighters.slim.util.StringUtil;

public class RequiredValidator
{
	//returns list of unset required fields
	public static List<String> validate(Command command)
	{
		List<String> list = new ArrayList<String>();
		List<Field> fields = getRequiredFields(command.getClass());
		for (Field f : fields)
		{
				try {
					Method m = command.getClass().getMethod("get" + StringUtil.capitalize(f.getName()));
					Object o = m.invoke(command);
					if (o==null)
					{
						list.add(f.getName());
					}
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		return list;
	}
	
	public static List<Field> getRequiredFields(Class<?> clazz)
	{
		List<Field> list = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields)
		{
			if (isRequired(f))
			{
				list.add(f);	
			}
		}
		
		if (clazz.getSuperclass() == null)
			return list;
		else
		{	
			list.addAll(getRequiredFields(clazz.getSuperclass()));
			return list;
		}
	}
	
	
	public static boolean isRequired(Field field)
	{
		Required r = field.getAnnotation(Required.class);
		return r != null;
	}
	
}
