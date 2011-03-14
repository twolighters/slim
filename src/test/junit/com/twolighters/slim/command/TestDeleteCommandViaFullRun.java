package com.twolighters.slim.command;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.twolighters.slim.Slim;
import com.twolighters.slim.SlimContext;

public class TestDeleteCommandViaFullRun
{
	File dir1,dir2,f1,f2,f3;
	
	@Before public void before() throws IOException
	{
		dir1 = new File("/temp/slim/test/dir1");
		dir2 = new File("/temp/slim/test/dir2");
		dir1.mkdirs();
		dir2.mkdirs();
		
		f1 = new File(dir1,"file.txt");
		f2 = new File(dir2,"file2.txt");
		f3 = new File(dir2,"file3.txt");
		
		f1.createNewFile();
		f2.createNewFile();
		f3.createNewFile();
	}
	
	
	@Test public void run() throws Exception
	{
		assertTrue(dir1.exists());
		assertTrue(dir2.exists());
		assertTrue(f1.exists());
		
		String[] args = {"delete.slim"};		
		SlimContext context = SlimContext.newInstance(args);
		Slim.run(context);
		
		assertTrue(dir1.exists());
		assertFalse(dir2.exists());
		assertFalse(f1.exists());
	}
}
