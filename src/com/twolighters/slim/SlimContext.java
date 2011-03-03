package com.twolighters.slim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twolighters.slim.log.ConsoleLogger;
import com.twolighters.slim.log.LoggerFactory;

public class SlimContext
{
	//constants
	public static String DEFAULT_SCRIPT_FILE = "default.slim";
	
	//TODO put args into replacement map
	
	private SlimContext(String[] args)
	{
		this.args = args;
		
		this.scriptSource = args == null ?
				DEFAULT_SCRIPT_FILE : args[0];
	}
	
	public static SlimContext newInstance()
	{
		return newInstance(null);
	}
	
	public static SlimContext newInstance(String[] args)
	{
		return new SlimContext(args);
	}

	private final String[] args;
	private final String scriptSource;
	
	public String getScriptSource()
	{
		return this.scriptSource;
	}
	
	public List<String> getArgs()
	{
		return new ArrayList<String>(Arrays.asList(this.args));
	}


	/*
	 * RAW SCRIPT (lines of raw script)
	 */
	private List<String> rawScript = new ArrayList<String>();
	
	public void addRawScript(List<String> lines)
	{
		this.rawScript.addAll(lines);
	}
	
	public List<String> getRawScript()
	{
		return new ArrayList<String>(this.rawScript);
	}
	
	public boolean scriptLoaded()
	{
		return this.rawScript.size() > 0;
	}

	
	/*
	 * LOGGER
	 */
	private ConsoleLogger logger = LoggerFactory.create();
	
	public ConsoleLogger getLogger()
	{
		return this.logger;
	}
	
	//the work directory, where temp downloads are stored
	private String workDir = System.getProperty("slim.work.dir");
	
	
	public void setWorkDir(String workDir)
	{
		this.workDir = workDir;
	}
	
	public String getWorkDir()
	{
		return this.workDir;
	}
	
	private Map<String,String> replacementMap = new HashMap<String,String>();
	
	public void addReplacement(String key, String value)
	{
		this.replacementMap.put(key, value);
	}
	
	public String getReplacement(String key)
	{
		return this.replacementMap.get(key);
	}
}
