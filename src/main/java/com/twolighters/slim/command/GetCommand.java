package com.twolighters.slim.command;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.twolighters.slim.SlimContext;
import com.twolighters.slim.command.annotations.Token;
import com.twolighters.slim.exceptions.CommandExecutionException;
import com.twolighters.slim.util.Base64;
import com.twolighters.slim.util.IOUtil;
import com.twolighters.slim.util.StringUtil;

@Token(name="GET")
public class GetCommand extends AbstractCommand
{
	
	public GetCommand(SlimContext context)
	{
		super(context);
	}

	@Token(name="FROM")
	private String resource = null;
	
	@Token(name="TO")
	private String destination = null;
	
	private String saveAs = null;
	
	//exepected to be 'username:password'
	@Token(name="AS")
	private String credentials = null;
	
	
	public void setResource(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return this.resource;
	}
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	public String getDestination()
	{
		return this.destination;
	}
	
	public void setSaveAs(String saveAs)
	{
		this.saveAs = saveAs;
	}
	
	
	
	public void setCredentials(String credentials)
	{
		this.credentials = credentials;
	}
	
	public String getCredentials()
	{
		return this.credentials;
	}
	
	@Override
	public boolean valid()
	{
		//TODO
		return true;
	}
	

	@Override
	public void execute()
	{
		//build local download path
		String localResource = this.destination + File.separator;
		if (this.saveAs != null)
		{
			localResource += this.saveAs;
		}
		else
		{
			localResource += StringUtil.urlResourceName(this.resource);
		}
		
		
		try
		{
			URL urlObj = new URL(this.resource);
			URLConnection conn = urlObj.openConnection();
			
			//set up authentication
			if (this.credentials != null)
			{
	             String encoding = Base64.encode(this.credentials);
	             conn.setRequestProperty("Authorization", "Basic " + encoding);
			}
			
			IOUtil.getRemoteContent(conn, localResource);
		}
		catch (IOException ioe)
		{
			throw new CommandExecutionException(ioe);
		}
			
	}

	@Override
	public void undo()
	{
		
		
		super.undo();

	}
	
	
}
