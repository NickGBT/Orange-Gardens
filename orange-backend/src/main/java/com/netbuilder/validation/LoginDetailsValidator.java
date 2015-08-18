package com.netbuilder.validation;

import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class LoginDetailsValidator
{
	public boolean validateLoginDetails(LoginDetails toBeValidated)
	{
		if(toBeValidated.getUsername().length() > 5 && toBeValidated.getUsername().length() < 25)
		{
			if(toBeValidated.getEmail().length() > 6 && toBeValidated.getEmail().length() < 254)
			{
				return true;
			}
		}
		return false;
	}
}