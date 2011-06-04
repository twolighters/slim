package com.twolighters.slim.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.SlimContext;

public class TestReplacementStrategy
{
	private SlimContext context = null; 
	private ReplacementStrategy strategy = null;
	
	@Before public void before()
	{
		context = SlimContext.newInstance();
		context.addReplacement("rep1", "value1");  //user-defined replacement
		context.addReplacement("rep2", "value2");  //user-defined replacement
		strategy = new ReplacementStrategy(context);
	}
	
	
	@Test public void nullString()
	{		
		String s = strategy.replace(null);
		assertNull(s);
	}
	
	
	@Test public void emptyString()
	{		
		String s = strategy.replace("");
		assertNull(s);
	}
	
	
	@Test public void userDefined()
	{		
		String s = strategy.replace("rep1");
		assertEquals("value1", s);
	}
	

	@Test public void userNotDefined()
	{		
		String s = strategy.replace("rep3");
		assertNull(s);
	}
	
	
	@Test public void beginsWithDelimiter()
	{		
		String s = strategy.replace(":SYSPROP");
		assertNull(s);
	}
	
	
	@Test public void endsWithDelimiter()
	{		
		String s = strategy.replace("SYSPROP:");
		assertNull(s);
	}
	
	
	@Test public void syspropNotExists()
	{		
		String s = strategy.replace("SYSPROP:my.test");
		assertNull(s);
	}
	
	
	@Test public void syspropExists()
	{
		System.setProperty("my.test", "foo");
		String s = strategy.replace("SYSPROP:my.test");
		assertEquals("foo", s);
	}
	
	
	@Test public void listInvalid()
	{
		String s = strategy.replace("LIST:XXX");
		assertNull(s);
	}
	
	
	@Test public void listEnv()
	{
		String s = strategy.replace("LIST:ENV");
		assertNotNull(s);
		System.out.println(s);
	}
	
	
	@Test public void listSysprop()
	{
		String s = strategy.replace("LIST:SYSPROP");
		assertNotNull(s);
		System.out.println(s);
	}
	
	
	@Test public void listUserDefined()
	{
		String s = strategy.replace("LIST:USER");
		assertNotNull(s);
		System.out.println(s);
	}

	
}
