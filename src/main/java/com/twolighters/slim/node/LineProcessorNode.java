package com.twolighters.slim.node;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.Command;
import com.twolighters.slim.command.builder.DefineCommandBuilder;
import com.twolighters.slim.command.builder.DeleteCommandBuilder;
import com.twolighters.slim.command.builder.EchoCommandBuilder;
import com.twolighters.slim.command.builder.ExecuteCommandBuilder;
import com.twolighters.slim.command.builder.GetCommandBuilder;
import com.twolighters.slim.exceptions.ScriptSyntaxException;

public class LineProcessorNode extends AbstractNode
{
	private ReplacementStrategy tokenReplacementStrategy;

	public LineProcessorNode(SlimContext context)
	{
		super(context);
		this.tokenReplacementStrategy = getReplacementStrategy();
	}

	@Override
	public void execute()
	{
		for (String line : getContext().getRawScript())
		{
			Command c = process(line);
			if (c==null)
			{
				getContext().getLogger().trace("command returned: null");
			}
			else
			{
				getContext().getLogger().trace("command returned: " + c.getClass().getName());
				c.execute();	
			}
			
		}
	}
	
	private Command process(String line)
	{
		getContext().getLogger().trace("LineProcessor: " + line);
		
		if (line==null) return null;
		String s = line.trim();
		if (s.equals("")) return null;
		if (isComment(s)) return null;
		
		s = performReplacement(s);
		
		Command c = new GetCommandBuilder(getContext()).build(s);
		if (c != null) return c;
		
		c = new EchoCommandBuilder(getContext()).build(s);
		if (c != null) return c;
		
		c = new ExecuteCommandBuilder(getContext()).build(s);
		if (c != null) return c;
		
		c = new DeleteCommandBuilder(getContext()).build(s);
		if (c != null) return c;

		c = new DefineCommandBuilder(getContext()).build(s);
		if (c != null) return c;
		
		throw new ScriptSyntaxException("Unknown command: " + line);

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
			String replacement = this.tokenReplacementStrategy.replace(token);
			if (replacement != null)
			{
				result = result.substring(0,start) + replacement + result.substring(end+1);
				searchIndex = start + replacement.length();
			}
		}
		
		getContext().getLogger().trace("performReplacement out: " + result);
		return result;
	}
	
	private ReplacementStrategy getReplacementStrategy()
	{
		return new ReplacementStrategy(getContext());
	}
	


}
