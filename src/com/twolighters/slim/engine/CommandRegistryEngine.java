package com.twolighters.slim.engine;

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


	private Map<String,Token> registry = new HashMap<String,Token>();
	
	public void register()
	{
		//TODO parse through command.impl package
		
		//call static method on each class that returns a metadata class
		//Token metadata = new Token();
		
		
		//register metadata in a map of metdata.getToken --> metadata
		//this.registry.put(metadata.getToken(), metadata);
		
	}
	
	
	public Command buildCommand(String[] args)
	{
		String token = args[0];
		Token metadata = this.registry.get(token);
		if (metadata == null)
		{
			throw new RuntimeException("Unknown token: " + token);
		}
		
		return null;
	}
	
	
}
