package com.twolighters.slim.command;
import java.io.IOException;

import com.twolighters.slim.SlimContext;


public class TestExecuteCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.setProperty("slim.work.dir", "/Users/Maso/slim-workdir");
		
		ExecuteCommand command =
			new ExecuteCommand(SlimContext.newInstance());
		
		command.setExecutable("/Users/Maso/tom.bat");
		try {
			command.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
