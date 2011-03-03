package com.twolighters.slim.engine;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.Command;
import com.twolighters.slim.command.annotations.Token;

public class CommandRegistryEngine extends AbstractEngine
{
	
	
	protected CommandRegistryEngine(SlimContext context)
	{
		super(context);
	}


	private Map<String,Class> registry = new HashMap<String,Class>();
	
	public void register()
	{
		//TODO parse through command.impl package
		
		//call static method on each class that returns a metadata class
		//Token metadata = new Token();
		
		
		//register metadata in a map of metdata.getToken --> metadata
		//this.registry.put(metadata.getToken(), metadata);
		
	}
	
	
	public Object buildCommand(String[] args)
	{
		String token = args[0];
		Class commandClass = this.registry.get(token);
		if (commandClass == null)
		{
			throw new RuntimeException("Unknown token: " + token);
		}
		
		for (Constructor c : commandClass.getConstructors())
		{
			//TODO
		}
		
		return null;
	}
	
	
}
