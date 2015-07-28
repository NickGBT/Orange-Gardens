package com.netbuilder.util;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class CustomerFeedback 
{
	private String userFeedback;
	
	public CustomerFeedback(String userFeedback)
	{
		this.setUserFeedback(userFeedback);
	}

	public String getUserFeedback()
	{
		return userFeedback;
	}

	public void setUserFeedback(String userFeedback)
	{
		this.userFeedback = userFeedback;
	}
}