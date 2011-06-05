package com.twolighters.slim.command;

import java.io.File;

import com.twolighters.slim.util.FileUtil;

public class FullRun
{
	public static String TEST_BASE_DIR = "/temp/slim/test";
	
	public static void deleteTestBaseDir()
	{
		File d = new File(TEST_BASE_DIR);
		FileUtil.deleteDirectory(d);
	}
}
