package com.twolighters.slim;

public class TestSlim
{
	
	private static String SCRIPT
		//= "/Users/Maso/dev/workspace/slim-scripts/test.slim";
		= "file:///Users/Maso/dev/workspace/slim-scripts/test.slim";
	
	public static void main(String[] args)
	{
		
		//System.setProperty("slim.log.level", "4");
		System.setProperty("slim.work.dir", "/Users/Maso/slim-workdir");
		
		try {
			//Slim.run(SlimContext.newInstance(SCRIPT));
			Slim.run(SlimContext.newInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
