package com.netbuilder.validation;

import com.netbuilder.entities.DeliveryLine;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class DeliveryLineValidator 
{
	public boolean validateDeliveryLine(DeliveryLine toBeValidated)
	{
		if(toBeValidated.getQuantity() == (int)toBeValidated.getQuantity())
		{
			return true;
		}
		return false;
	}
}