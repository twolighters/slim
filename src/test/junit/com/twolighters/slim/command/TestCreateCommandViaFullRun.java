package com.twolighters.slim.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.Slim;
import com.twolighters.slim.SlimContext;

public class TestCreateCommandViaFullRun
{
	File dir1, dir2, f1;
	
	@Before public void before() throws IOException
	{
		FullRun.deleteTestBaseDir();
		
		dir1 = new File( FullRun.TEST_BASE_DIR + "/dir1");
		dir1.mkdirs();
		
		dir2 = new File( dir1, "dir2" );
		f1 = new File( dir1, "foo.txt" );
		
	}
	
	
	@Test public void run() throws Exception
	{
		assertTrue(dir1.exists());
		assertFalse(dir2.exists());
		assertFalse(f1.exists());
		
		String[] args = {"create.slim"};		
		SlimContext context = SlimContext.newInstance(args);
		Slim.run(context);
		
		assertTrue(dir1.exists());
		assertTrue(dir2.exists());
		assertTrue(f1.exists());
	}
}
