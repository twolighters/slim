package com.twolighters.slim.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.util.IOUtil;

public class ScriptLoaderEngine extends AbstractEngine
{

	
	public ScriptLoaderEngine(SlimContext context)
	{
		super(context);
	}
	
	public void run() throws Exception
	{
		String scriptSource = getContext().getScriptSource();

		try {
			URL url = new URL(scriptSource);
			loadFromUrl(url);
		} catch (MalformedURLException e)
		{
			//do nothing and fall through to next block
		}
		
		if (!getContext().scriptLoaded())
		{
			if (scriptSource.startsWith("/"))
			{
				loadFromFilesystem(scriptSource);
			}
			else
			{
				loadFromClasspath(scriptSource);
			}
		}
	}
	
	private void loadFromUrl(URL url) throws IOException
	{		
		InputStream is = url.openStream();
		getContext().addRawScript( IOUtil.readLines(is) );
		IOUtil.close(is);
	}
	
	private void loadFromFilesystem(String resource) throws IOException
	{
		File file = new File(resource);
		FileInputStream fin = new FileInputStream(file);
		getContext().addRawScript( IOUtil.readLines(fin) );
		IOUtil.close(fin);
	}
	
	private void loadFromClasspath(String resource)
	{
		//TODO
		throw new UnsupportedOperationException("Slim does not support classpath loading at this time.");
		
	}
	
	

}
