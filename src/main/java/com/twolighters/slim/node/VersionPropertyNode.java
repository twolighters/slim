package com.twolighters.slim.node;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import com.twolighters.slim.SlimContext;

public class VersionPropertyNode extends AbstractNode
{

	public VersionPropertyNode(SlimContext context)
	{
		super(context);
	}

	@Override
	public void execute()
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

}
