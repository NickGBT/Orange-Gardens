package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Named
@RequestScoped
public class UserDetails
{
	private String name;
	private String password;
	private int uid;
	
	public UserDetails(String name, String password) 
	{
		this.setName(name);
		this.setPassword(password);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public int getUid() 
	{
		return uid;
	}

	public void setUid(int uid) 
	{
		this.uid = uid;
	}
}