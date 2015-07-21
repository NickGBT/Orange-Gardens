package com.netbuilder.controllers;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.netbuilder.entity_managers.arraylist.CustomerManagerAL;
import com.netbuilder.util.RegistrationDetails;
import com.netbuilder.util.UserDetails;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class LoginController
{
	@Inject
	private CustomerManagerAL customerManager;
	@Inject
	private UserDetails userDetails;
	private String errorMsg;
	
	public void checkSignInMethod()
	{
		if(userDetails.getTempStorage().contains("@"))
		{
			userDetails.setEmail(userDetails.getTempStorage());
			loginWithEmail();
		}
		else
		{
			userDetails.setUsername(userDetails.getTempStorage());
			loginWithUsername();
		}
	}
	
	public String loginWithUsername()
	{
		if (userDetails.getUsername().isEmpty() || userDetails.getPassword().isEmpty()) 
		{
			errorMsg = "please enter details";
			return "login";
		}
		Long uid = customerManager.checkUsernameDetails(userDetails.getUsername(), userDetails.getPassword());
		if(uid == -1)
		{
			errorMsg = "Incorrect details";
			return "login";
		}
		return "account/uid";
	}
	
	public String loginWithEmail()
	{
		if (userDetails.getEmail().isEmpty() || userDetails.getPassword().isEmpty()) 
		{
			errorMsg = "please enter details";
			return "login";
		}
		Long uid = customerManager.checkEmailDetails(userDetails.getEmail(), userDetails.getPassword());
		if(uid == -1)
		{
			errorMsg = "Incorrect details";
			return "login";
		}
		return "account/uid";
	}
	
	public String logout() throws LoginException
	{
		userDetails.setUsername(null);
		userDetails.setPassword(null);
		return "home";
	}

	public String getErrorMsg() 
	{
		return errorMsg;
	}
}