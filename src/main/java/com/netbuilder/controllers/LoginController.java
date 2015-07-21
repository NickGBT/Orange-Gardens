package com.netbuilder.controllers;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;
import com.netbuilder.util.UserDetails;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class LoginController
{
	@Inject
	private LoginDetailsManagerAL loginManager;
	@Inject
	private UserDetails userDetails;
	private String errorMsg;
	
	public String login()
	{
		if (userDetails.getName().isEmpty() || userDetails.getPassword().isEmpty()) 
		{
			errorMsg = "please enter details";
			return "login";
		}
		int uid = loginManager.checkPassword(userDetails.getName(), userDetails.getPassword());
		if(uid == -1)
		{
			errorMsg = "Incorrect details";
			return "login";
		}
		return "account/uid";
	}
	
	public String logout() throws LoginException
	{
		userDetails.setName(null);
		userDetails.setPassword(null);
		return "home";
	}

	public String getErrorMsg() 
	{
		return errorMsg;
	}
}