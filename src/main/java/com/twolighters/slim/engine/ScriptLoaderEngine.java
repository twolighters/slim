package com.twolighters.slim.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.exceptions.ScriptLoadException;
import com.twolighters.slim.util.IOUtil;

public class ScriptLoaderEngine extends AbstractEngine
{

	
	public ScriptLoaderEngine(SlimContext context)
	{
		super(context);
	}
	
	public void run()
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
	
	private void loadFromUrl(URL url)
	{	
		try
		{
			InputStream is = url.openStream();
			getContext().addRawScript( IOUtil.readLines(is) );
			IOUtil.close(is);
		}
		catch (IOException ioe)
		{
			throw new ScriptLoadException(ioe);
		}
	}
	
	private void loadFromFilesystem(String resource)
	{
		try
		{
			File file = new File(resource);
			FileInputStream fin = new FileInputStream(file);
			getContext().addRawScript( IOUtil.readLines(fin) );
			IOUtil.close(fin);
		}
		catch (IOException ioe)
		{
			throw new ScriptLoadException(ioe);
		}
	}
	
	private void loadFromClasspath(String resource)
	{
		try
		{
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
			getContext().addRawScript( IOUtil.readLines(is) );
			IOUtil.close(is);
		}
		catch (IOException ioe)
		{
			throw new ScriptLoadException(ioe);
		}
	}
	
	

}
