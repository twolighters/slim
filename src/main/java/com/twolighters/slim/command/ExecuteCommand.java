package com.twolighters.slim.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;

@Token(name={"EXEC","EXECUTE"})
public class ExecuteCommand extends AbstractCommand
{

	public ExecuteCommand(SlimContext context)
	{
		super(context);
	}
	
	@Token(name="FILE")
	private String executable = null;
	private String[] env = null;
	private String workingDir = null;
	
	@Token(name="UNDOFILE")
	private String undoExecutable = null;
	
	public void setExecutable(String executable)
	{
		this.executable = executable;
	}
	
	public String getExecutable()
	{
		return this.executable;
	}

	public void setEnv(String[] env)
	{
		this.env = env;
	}
	
	public String[] getEnv()
	{
		return this.env;
	}
	
	public void setWorkingDir(String workingDir)
	{
		this.workingDir = workingDir;
	}
	
	public String getWorkingDir()
	{
		return this.workingDir;
	}
	
	public void setUndoExecutable(String undoExecutable)
	{
		this.undoExecutable = undoExecutable;
	}
	

	
	
	@Override
	public void execute() throws IOException
	{
		File work = this.workingDir == null ? null : new File(this.workingDir);
		Process p = Runtime.getRuntime().exec(this.executable, this.env, work);
		
		String line;
		BufferedReader input =
	        new BufferedReader
	          (new InputStreamReader(p.getInputStream()));
	      while ((line = input.readLine()) != null) {
	        System.out.println(line);
	      }
	      input.close();
	}
	
	@Override
	public void undo() throws IOException
	{
		Runtime.getRuntime().exec(this.undoExecutable, null, null);
	}

}
