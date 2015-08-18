package com.netbuilder.validation;

import com.netbuilder.entities.Customer;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class CustomerValidator
{
	public boolean validateCustomer(Customer toBeValidated)
	{
		if(toBeValidated.getfName().length() > 1 && toBeValidated.getlName().length() < 20)
		{
			if(toBeValidated.getlName().length() > 1 && toBeValidated.getlName().length() < 45)
			{
				if(toBeValidated.getContactNumber().length() > 1 && toBeValidated.getContactNumber().length() < 45)
				{
					if(toBeValidated.isBlackListed() == true || toBeValidated.isBlackListed() == false)
					{				
						return true;		
					}
				}
			}
		}
		return false;
	}
}