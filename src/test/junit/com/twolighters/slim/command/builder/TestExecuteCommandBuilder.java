package com.twolighters.slim.command.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.ExecuteCommand;
import com.twolighters.slim.exceptions.ContextNotInstantiatedException;
import com.twolighters.slim.exceptions.ScriptSyntaxException;

public class TestExecuteCommandBuilder
{
	private SlimContext context = null; 
	private ExecuteCommandBuilder builder = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		builder = new ExecuteCommandBuilder(context);
	}
	
	@Test(expected= ContextNotInstantiatedException.class)
	public void nullContext() throws Exception
	{
		new ExecuteCommandBuilder(null);
	}
		
	
	@Test public void nullString()
	{		
		ExecuteCommand c = builder.build(null);
		assertNull(c);
	}
	
	@Test public void emptyString()
	{		
		ExecuteCommand c = builder.build("");
		assertNull(c);
	}
	
	@Test public void wrongCommand()
	{
		ExecuteCommand c = builder.build("GET http://www.google.com/");
		assertNull(c);
	}
	
	@Test public void noArgs()
	{		
		ExecuteCommand c = builder.build("EXEC");
		assertNull(c);
	}
	
	@Test public void onlyExecutable()
	{
		ExecuteCommand c = builder.build("EXEC dir");
		assertEquals("dir",c.getCommand());
		assertNull(c.getEnv());
		assertNull(c.getWorkingDir());
	}
	
	@Test public void executableAndEnv()
	{
		ExecuteCommand c = builder.build("EXEC dir ENV key1=value1,key2=value2");
		assertEquals("dir",c.getCommand());
		assertNotNull(c.getEnv());
		assertNull(c.getWorkingDir());
	}
	
	@Test public void executableAndWorkDir()
	{
		ExecuteCommand c = builder.build("EXEC dir IN /tmp");
		assertEquals("dir",c.getCommand());
		assertNull(c.getEnv());
		assertEquals("/tmp",c.getWorkingDir());
	}

	
	@Test public void threeArgs()
	{
		ExecuteCommand c = builder.build("EXEC dir ENV key1=value1,key2=value2 IN /tmp");
		assertEquals("dir",c.getCommand());
		assertNotNull(c.getEnv());
		assertEquals("/tmp",c.getWorkingDir());
	}
	
	@Test(expected= ScriptSyntaxException.class)
	public void error1()
	{
		builder.build("EXEC unzip -q my.zip");
	}
	
	@Test public void quotedExecutable()
	{
		ExecuteCommand c = builder.build("EXEC \"unzip -q my.zip\"");
		assertEquals("unzip -q my.zip",c.getCommand());
	}
	
	@Test public void threeArgsQuoted()
	{
		ExecuteCommand c = builder.build("EXEC \"unzip -q my.zip\" ENV key1=value1,key2=value2 IN /tmp");
		assertEquals("unzip -q my.zip",c.getCommand());
		assertNotNull(c.getEnv());
		assertEquals("/tmp",c.getWorkingDir());
	}
	
}
