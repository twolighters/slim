package com.twolighters.slim.command;

import java.io.File;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.util.FileUtil;

public class DeleteCommand extends AbstractCommand
{

	public DeleteCommand(SlimContext context)
	{
		super(context);
	}
	
	private String resource;
	private boolean result = false;
	
	public void setResource(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return this.resource;
	}
	
	public boolean getResult()
	{
		return this.result;
	}
	
	
	@Override
	public void execute()
	{
		File file = new File(this.resource);
		if (file.exists())
		{
			this.result =
				file.isDirectory() ?
				FileUtil.deleteDirectory(file) :
				file.delete();
		}
	}

}
