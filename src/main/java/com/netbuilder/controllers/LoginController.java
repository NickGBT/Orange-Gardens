package com.netbuilder.controllers;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;
import com.netbuilder.util.CustomerUserId;
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
	private int uid;
	
	public String login()
	{
		if (userDetails.getName().isEmpty() || userDetails.getPassword().isEmpty()) 
		{
			errorMsg = "please enter details";
			return "login";
		}
		uid = loginManager.checkPassword(userDetails.getName(), userDetails.getPassword());
		if(uid == -1)
		{
			CustomerUserId.setUid(uid);
			errorMsg = "Incorrect details";
			return "login";
		}
		return "account/uid";
	}
	
	public String logout() throws LoginException
	{
		userDetails.setName(null);
		userDetails.setPassword(null);
		CustomerUserId.setUid(0);
		return "home";
	}

	public String getErrorMsg() 
	{
		return errorMsg;
	}
}