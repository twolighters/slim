package com.twolighters.slim.command;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.CommandToken;

@CommandToken(value="TUNE")
public class TuneCommand extends SlimCommand
{

	protected TuneCommand(SlimContext context)
	{
		super(context);
	}
	
	private int interval = 15;  //default to 15 secs.
	
	public void setInterval(int interval)
	{
		this.interval = interval;
	}
	
	@Override
	public void execute()
	{
		
		while (true)
		{
			super.execute();
			try {
				Thread.sleep(this.interval * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// do nothing?
			}
		}
		

	}

}
