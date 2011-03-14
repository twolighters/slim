package com.twolighters.slim.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.Slim;
import com.twolighters.slim.SlimContext;

public class TestGetCommandViaFullRun
{
	File dir1,f1;
	
	@Before public void before() throws IOException
	{
		dir1 = new File("/temp/slim/test/get");
		dir1.mkdirs();
		
		f1 = new File(dir1,"README");
		f1.delete();
	}
	
	
	@Test public void run() throws Exception
	{
		assertTrue(dir1.exists());
		assertFalse(f1.exists());
		
		String[] args = {"get.slim"};		
		SlimContext context = SlimContext.newInstance(args);
		Slim.run(context);
		
		assertTrue(dir1.exists());
		assertTrue(f1.exists());
	}
}
