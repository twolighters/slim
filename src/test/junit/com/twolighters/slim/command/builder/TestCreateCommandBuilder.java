package com.twolighters.slim.command.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.CreateCommand;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;

public class TestCreateCommandBuilder
{
	private SlimContext context = null; 
	private CreateCommandBuilder builder = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		builder = new CreateCommandBuilder(context);
	}
	
	@Test(expected= ContextNotInstantiatedException.class)
	public void nullContext() throws Exception
	{
		new CreateCommandBuilder(null);
	}
		
	
	@Test public void nullString()
	{		
		CreateCommand c = builder.build(null);
		assertNull(c);
	}
	
	@Test public void emptyString()
	{		
		CreateCommand c = builder.build("");
		assertNull(c);
	}
	
	@Test public void wrongCommand()
	{
		CreateCommand c = builder.build("GET http://www.google.com/");
		assertNull(c);
	}
	
	@Test public void noArgs()
	{		
		CreateCommand c = builder.build("CREATE");
		assertNull(c);
	}
	
	@Test public void wrongAtribute()
	{
		CreateCommand c = builder.build("CREATE FOO bar");
		assertNull(c);
	}
	
	@Test public void dirAtribute()
	{
		CreateCommand c = builder.build("CREATE DIR bar");
		assertEquals("bar",c.getDirectory());
		assertNull(c.getFile());
	}
	
	@Test public void fileAtribute()
	{
		CreateCommand c = builder.build("CREATE FILE bar");
		assertEquals("bar",c.getFile());
		assertNull(c.getDirectory());
	}
}
