package com.twolighters.slim.engine;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.Command;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;
import com.twolighters.slim.exceptions.ScriptSyntaxException;

public class TestLineProcessor
{
	private SlimContext context = null; 
	private LineProcessor processor = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		processor = new LineProcessor(context);
	}
	
	@Test(expected= ContextNotInstantiatedException.class)
	public void nullContext() throws Exception
	{
		new LineProcessor(null);
	}
	
	@Test public void nullString()
	{		
		Command c = processor.process(null);
		assertNull(c);
	}
	
	@Test public void emptyString()
	{		
		Command c = processor.process("");
		assertNull(c);
	}
	
	@Test public void spaces()
	{		
		Command c = processor.process("  ");
		assertNull(c);
	}
	
	@Test public void comment1()
	{		
		Command c = processor.process("# ...");
		assertNull(c);
	}
	
	@Test public void comment2()
	{		
		Command c = processor.process(" # ... ");
		assertNull(c);
	}
	
	@Test(expected= ScriptSyntaxException.class)
	public void unknownCommand()
	{		
		Command c = processor.process("UGH i dunno");
		assertNull(c);
	}
}
