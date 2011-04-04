package com.twolighters.slim.command;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.Slim;
import com.twolighters.slim.SlimContext;

public class TestExecuteCommandViaFullRun
{
	File dir1;
	
	@Before public void before() throws IOException
	{
		dir1 = new File("/temp/slim/test");
		dir1.mkdirs();
	}
	
	
	@Test public void run() throws Exception
	{		
		String[] args = {"execute.slim"};		
		SlimContext context = SlimContext.newInstance(args);
		Slim.run(context);
		
		//TODO capture and test output of EXEC
	}
}
