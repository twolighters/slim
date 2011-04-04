package com.twolighters.slim.command.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.GetCommand;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;

public class TestGetCommandBuilder
{
	private SlimContext context = null; 
	private GetCommandBuilder builder = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		builder = new GetCommandBuilder(context);
	}
	
	@Test(expected= ContextNotInstantiatedException.class)
	public void nullContext() throws Exception
	{
		new GetCommandBuilder(null);
	}
		
	
	@Test public void nullString()
	{		
		GetCommand c = builder.build(null);
		assertNull(c);
	}
	
	@Test public void emptyString()
	{		
		GetCommand c = builder.build("");
		assertNull(c);
	}
	
	@Test public void wrongCommand()
	{
		GetCommand c = builder.build("DELETE /mydir");
		assertNull(c);
	}
	
	@Test public void noArgs()
	{		
		GetCommand c = builder.build("GET");
		assertNull(c);
	}
	
	@Test public void onlyResource()
	{
		GetCommand c = builder.build("GET http://www.google.com/");
		assertEquals("http://www.google.com/",c.getResource());
		assertNull(c.getDestination());
		assertNull(c.getCredentials());
	}
	
	@Test public void resourceAndDestination()
	{
		GetCommand c = builder.build("GET http://www.google.com/ TO /mydir");
		assertEquals("http://www.google.com/",c.getResource());
		assertEquals("/mydir", c.getDestination());
		assertNull(c.getCredentials());
	}
	
	@Test public void resourceAndCredentials()
	{
		GetCommand c = builder.build("GET http://www.google.com/ AS user:pwd");
		assertEquals("http://www.google.com/",c.getResource());
		assertNull(c.getDestination());
		assertEquals("user:pwd", c.getCredentials());
	}

	
	@Test public void threeArgs()
	{
		GetCommand c = builder.build("GET http://www.google.com/ TO /mydir AS user:pwd");
		assertEquals("http://www.google.com/",c.getResource());
		assertEquals("/mydir", c.getDestination());
		assertEquals("user:pwd", c.getCredentials());
	}
	
}
