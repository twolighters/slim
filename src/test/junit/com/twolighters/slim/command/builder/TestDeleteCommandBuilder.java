package com.twolighters.slim.command.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.SlimContextNotInstantiatedException;
import com.twolighters.slim.command.DeleteCommand;

public class TestDeleteCommandBuilder
{
	private SlimContext context = null; 
	private DeleteCommandBuilder builder = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		builder = new DeleteCommandBuilder(context);
	}
	
	@Test(expected= SlimContextNotInstantiatedException.class)
	public void nullContext() throws Exception
	{
		new DeleteCommandBuilder(null);
	}
		
	
	@Test public void nullString()
	{		
		DeleteCommand c = builder.build(null);
		assertNull(c);
	}
	
	@Test public void emptyString()
	{		
		DeleteCommand c = builder.build("");
		assertNull(c);
	}
	
	@Test public void wrongCommand()
	{
		DeleteCommand c = builder.build("GET http://www.google.com/");
		assertNull(c);
	}
	
	@Test public void noArgs()
	{		
		DeleteCommand c = builder.build("DELETE");
		assertNull(c);
	}
	
	@Test public void oneArg()
	{
		DeleteCommand c = builder.build("DELETE dir");
		assertEquals("dir",c.getResource());
	}
	
	
}
