package com.netbuilder.orange_gardens;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class Customer 
{
	private int customerID;
	private String fName;
	private String lName;
	private String username;
	private String password;
	private String emailAddress;
	private boolean isBlackListed;
	
	public int getCustomerID()
	{
		return customerID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
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

	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) 
	{
		this.emailAddress = emailAddress;
	}

	public boolean isBlackListed() 
	{
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed) 
	{
		this.isBlackListed = isBlackListed;
	}
}