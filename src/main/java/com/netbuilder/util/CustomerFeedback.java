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