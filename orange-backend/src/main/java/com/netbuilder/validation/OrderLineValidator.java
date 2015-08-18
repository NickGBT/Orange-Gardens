package com.netbuilder.validation;

import com.netbuilder.entities.OrderLine;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class OrderLineValidator 
{
	public boolean validateOrderLine(OrderLine toBeValidated)
	{
		if(toBeValidated.getQuantity() == (int)toBeValidated.getQuantity())
		{
			return true;
		}
		return false;
	}
}