package com.netbuilder.validation;

import com.netbuilder.entities.Address;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class AddressValidator
{
	public boolean validateAddress(Address toBeValidated)
	{
		if(toBeValidated.getAddressLabel().length() > 2 && toBeValidated.getAddressLabel().length() < 45)
		{
			if(toBeValidated.getAddressLine1().length() > 0 && toBeValidated.getAddressLine1().length() < 45)
			{
				if(toBeValidated.getAddressLine2().length() > 0 && toBeValidated.getAddressLine2().length() < 45)
				{
					if(toBeValidated.getAddressLine3().length() > 0 && toBeValidated.getAddressLine3().length() < 45)
					{
						if(toBeValidated.getCity().length() > 2 && toBeValidated.getCity().length() < 45)
						{
							if(toBeValidated.getCounty().length() > 2 && toBeValidated.getCounty().length() < 45)
							{
								if(toBeValidated.getPostcode().length() > 6 && toBeValidated.getPostcode().length() < 8)
								{
									if(toBeValidated.isBillingAddress() == true || toBeValidated.isBillingAddress() == false)
									{				
										return true;		
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}