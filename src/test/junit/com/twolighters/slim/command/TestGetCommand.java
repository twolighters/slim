package com.twolighters.slim.command;
import java.io.IOException;

import com.twolighters.slim.SlimContext;


public class TestGetCommand
{
	public static void main(String[] args)
	{
		System.setProperty("slim.work.dir", "/Users/Maso/slim-workdir");
		
		GetCommand command = new GetCommand(SlimContext.newInstance());
		command.setResource("http://build1.copyright.com:8080/luntbuild/publish/dsc/release/1.0-025/artifacts/dsc-1.0-025.zip");
		
		//command.setSaveAs("tom.html");
		try {
			command.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
