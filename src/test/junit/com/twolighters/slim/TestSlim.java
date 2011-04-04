package com.twolighters.slim;

import org.junit.Test;

import com.twolighters.slim.exceptions.ContextNotInstantiatedException;

public class TestSlim
{
	
	@Test(expected= ContextNotInstantiatedException.class)
	public void runNull() throws Exception
	{
		Slim.run(null);
	}
	
	
	@Test public void runEmptyContext() throws Exception
	{
		Slim.run(SlimContext.newInstance());
	}
	
	
	@Test public void runContextWithEmptyArgs() throws Exception
	{
		String[] args = {};
		
		Slim.run(SlimContext.newInstance(args));
	}
	
	
	@Test public void runContextWithArgs() throws Exception
	{
		String[] args = {"default.slim", "one", "two", "three"};
		
		Slim.run(SlimContext.newInstance(args));
	}
}
