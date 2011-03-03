package com.twolighters.slim.engine;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.Command;
import com.twolighters.slim.command.DefineCommand;
import com.twolighters.slim.command.EchoCommand;
import com.twolighters.slim.command.ExecuteCommand;
import com.twolighters.slim.command.GetCommand;

/**
 * This needs a lot of work, of course.
 */
public class LineProcessor extends AbstractEngine
{
	private final TokenReplacementStrategy tokenReplacementStrategy;
	
	protected LineProcessor(SlimContext context)
	{
		super(context);
		this.tokenReplacementStrategy = new TokenReplacementStrategy(context);
	}

	public Command process(String line)
	{
		getContext().getLogger().trace("LineProcessor: " + line);
		
		if (line==null) return null;
		String s = line.trim();
		if (line.equals("")) return null;
		if (isComment(s)) return null;
		
		s = performReplacement(s);
		
		if (s.startsWith("GET"))
		{
			GetCommand c = new GetCommand(getContext());
			int as = s.indexOf(" AS");
			if (as < 0)
			{
				c.setResource(s.substring(4));
			}
			else
			{
				c.setResource(s.substring(4,as));
				c.setCredentials(s.substring(as+4));
			}
			return c;
		}
		if (s.startsWith("EXEC"))
		{
			ExecuteCommand c = new ExecuteCommand(getContext());
			c.setExecutable(s.substring(5));
			return c;
		}
		if (s.equals("ECHO"))
		{
			EchoCommand c = new EchoCommand(getContext());
			c.setText("");
			return c;			
		}		
		if (s.startsWith("ECHO"))
		{
			EchoCommand c = new EchoCommand(getContext());
			c.setText(s.substring(5));
			return c;			
		}
		if (s.startsWith("DEFINE"))
		{
			DefineCommand c = new DefineCommand(getContext());
			int as = s.indexOf(" AS");
			String key = s.substring(7,as);
			String value = s.substring(as+4);
			c.setKey(key);
			c.setValue(value);
			return c;			
		}
		
		return null;
	}
	
	private boolean isComment(String line)
	{
		return line.startsWith("#");
	}
	
	private String performReplacement(String s)
	{
		getContext().getLogger().trace("performReplacement in: " + s);
		String result = s;

		int searchIndex = 0;
		while (result.indexOf('[', searchIndex) > -1)
		{
			int start = result.indexOf('[', searchIndex);
			int end = result.indexOf(']', searchIndex);
			String token = result.substring(start+1,end);
			getContext().getLogger().trace("token found: " + token);
			String replacement = tokenReplacementStrategy.replace(token);
			if (replacement != null)
			{
				result = result.substring(0,start) + replacement + result.substring(end+1);
				searchIndex = start + replacement.length();
			}
		}
		
		getContext().getLogger().trace("performReplacement out: " + result);
		return result;
	}
	
	public static void main(String[] args)
	{
		System.setProperty("slim.version", "vvvvv");
		System.setProperty("slim.build.date", "bbb");
		LineProcessor p = new LineProcessor(SlimContext.newInstance());
		System.out.println(p.performReplacement("ECHO Slim version [SYS:slim.version], [SYS:slim.build.date]"));
		
	}
}
