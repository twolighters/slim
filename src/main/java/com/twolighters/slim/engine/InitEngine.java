package com.twolighters.slim.engine;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.twolighters.slim.SlimContext;

public class InitEngine extends AbstractEngine
{

	public InitEngine(SlimContext context)
	{
		super(context);
	}
	
	public void run()
	{
		loadVersionProperties();
		loadCommandLineArgs();
	}
	
	private void loadVersionProperties()
	{
		try
		{
			InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("version.properties");
			Properties properties = new Properties();
			properties.load(stream);
			
			for (Iterator<Object> iter = properties.keySet().iterator(); iter.hasNext(); )
			{
				String key = (String) iter.next();
				//System.out.println(key);
				System.setProperty(key, properties.getProperty(key));
			}
		}
		catch (Exception e)
		{
			//could not load the version properties, so default them.
			System.setProperty("slim.version", "<unknown version>");
			System.setProperty("slim.build.date", "<unknown build date>");
		}
	}
	
	private void loadCommandLineArgs()
	{
		List<String> args = getContext().getArgs();
		
		if (args != null)
		{
			for (int i = 0; i < args.size(); i++)
			{
				getContext().addReplacement(Integer.toString(i), args.get(i));
			}
		}
	}

}
