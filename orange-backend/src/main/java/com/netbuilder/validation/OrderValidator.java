package com.netbuilder.validation;

import com.netbuilder.entities.Order;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class OrderValidator
{
	public boolean validateOrder(Order toBeValidated)
	{
		if(toBeValidated.getOrderStatus().getClass().isEnum())
		{
			return true;
		}
		return false;
	}
}