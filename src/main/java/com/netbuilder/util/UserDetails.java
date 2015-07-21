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
	private String tempStorage;
	private String username;
	private String password;
	private String email;
	
	public UserDetails(String tempStorage, String password) 
	{
		this.setTempStorage(tempStorage);
		this.setPassword(password);
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTempStorage() 
	{
		return tempStorage;
	}

	public void setTempStorage(String tempStorage)
	{
		this.tempStorage = tempStorage;
	}
}