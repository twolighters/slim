package com.twolighters.slim.command.strategy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.ExecuteCommand;
import com.twolighters.slim.exceptions.CommandExecutionException;
import com.twolighters.slim.util.StringUtil;
import com.twolighters.slim.util.StringUtil.KeyValue;

public abstract class AbstractExecuteXS extends ExecuteStrategy<ExecuteCommand>
{

	public AbstractExecuteXS(SlimContext context)
	{
		super(context);
	}
	
	protected void executeCore(String[] splitCommand, String workDir, String[] env)
	{
		File work = workDir == null ? null : new File(workDir);
		ProcessBuilder pb = new ProcessBuilder(splitCommand);
		pb.directory(work);
		
		if (env != null)
		{
			Map<String,String> map = pb.environment();
			for (String envMapping : env)
			{
				KeyValue kv = StringUtil.splitKeyAndValue(envMapping, "=");
				if (kv != null)
				{
					map.put(kv.getKey(), kv.getValue());
				}
			}
		}
		
		try
		{
			Process p = pb.start();
		
				//TODO the following just logs to console.  rework it.
				try
				{
				String line;
				BufferedReader input =
			        new BufferedReader
			          (new InputStreamReader(p.getInputStream()));
			      while ((line = input.readLine()) != null) {
			        System.out.println(line);
			      }
			      input.close();
				}
				catch (IOException ioe)
				{
					//do nothing?
				}
		}
		catch (IOException ioe)
		{
			throw new CommandExecutionException(ioe);
		}
	}

}
