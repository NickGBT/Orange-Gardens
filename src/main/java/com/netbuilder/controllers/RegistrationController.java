package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.inject.Inject;

import com.netbuilder.util.RegistrationDetails;

/**
 * 
 * @author llew
 *
 */

public class RegistrationController
{
	@Inject
	private RegistrationDetails registrationDetails;
	private String errorMsg;
	private Customer customer;
	private LoginDetails loginDetails;
	private Address address;
	private PaymentDetails payDetails;
	
	public String registerCustomer()
	{
		
		if(registrationDetails.checkAllUserEntries())
		{
			
			return "account/uid";
		}
		else
		{
			errorMsg = "Invalid entries";
			return "RegisterCustomer";
		}
	}
}