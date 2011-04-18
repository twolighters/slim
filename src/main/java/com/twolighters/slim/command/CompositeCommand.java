package com.twolighters.slim.command;

import java.util.List;
import java.util.ListIterator;

public class CompositeCommand implements Command
{
	
	List<Command> commands;
	
	

	@Override
	public void execute() throws Exception
	{
		for (Command c : commands)
		{
			c.execute();
		}

	}

	@Override
	public void undo() throws Exception
	{
		//this creates an iterator with the index at the end of the list
		ListIterator<Command> iter = commands.listIterator(commands.size());
		
		while (iter.hasPrevious())
		{
			Command c = iter.previous();
			c.undo();
		}
	}
	

	@Override
	public boolean executed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean valid()
	{
		//TODO
		return true;
	}

}
