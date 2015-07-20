package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.util.UserDetails;

public class LoginController {
	@Inject
	private CustomerLoginManager clm;
	@Inject
	private UserDetails ud;
	public String errormsg;
	
	public String login() {
		if (ud.username.isEmpty() || ud.password.isEmpty()) {
			errormsg = "please enter details";
			return "login";
		}
		Long uid = clm.checkDetails(ud.username, ud.password);
		if(uid == null)
		{
			errormsg = "Incorrect details";
			return "login";
		}
		return "account/uid";
	}
}