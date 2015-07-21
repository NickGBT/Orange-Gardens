package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.util.RegistrationDetails;

/**
 * 
 * @author 
 *
 */

public class RegistrationController
{
	@Inject
	private RegistrationDetails registrationDetails;
	private String errorMsg;
	
	public String registerCustomer()
	{
		if(registrationDetails.checkAllUserEntries())
		{
			
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid entries";
			return "login";
		}
	}
}