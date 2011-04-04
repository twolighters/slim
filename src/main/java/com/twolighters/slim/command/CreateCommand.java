package com.twolighters.slim.command;

import java.io.File;
import java.io.IOException;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;

@Token(name={"CREATE"})
public class CreateCommand extends AbstractCommand
{


	public CreateCommand(SlimContext context)
	{
		super(context);
	}
	
	@Token(name={"DIR"})
	private String directory = null;
	@Token(name={"FILE"})
	private String file = null;
	
	
	public String getDirectory()
	{
		return this.directory;
	}

	public void setDirectory(String directory)
	{
		this.directory = directory;
	}

	public String getFile()
	{
		return this.file;
	}

	public void setFile(String file)
	{
		this.file = file;
	}



	@Override
	public void execute() throws IOException
	{
		if (this.directory != null)
		{
			File dir = new File(this.directory);
			dir.mkdirs();
		}
		else if (this.file != null)
		{
			File f = new File(this.file);
			f.createNewFile();
		}
		else
		{
			//TODO exception
		}
	}

}
