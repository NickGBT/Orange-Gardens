package com.netbuilder.validation;

import com.netbuilder.entities.Delivery;
import com.netbuilder.enums.DeliveryStatus;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class DeliveryValidator 
{
	public boolean validateDelivery(Delivery toBeValidated)
	{
		if(toBeValidated.getDeliveryStatus().getClass().isEnum())
		{
			if(toBeValidated.getDatePlaced().length() > 2 && toBeValidated.getDatePlaced().length() < 45)
			{
				if(toBeValidated.getSupplier().length() > 2 && toBeValidated.getSupplier().length() < 45)
				{
					if(toBeValidated.getPrice() == (double)toBeValidated.getPrice())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}