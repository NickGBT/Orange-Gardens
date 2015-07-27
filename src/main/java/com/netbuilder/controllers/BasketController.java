package com.netbuilder.controllers;

import javax.inject.Inject;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.util.OrderDetails;
import com.netbuilder.entities.Order;

/**
 * 
 * @author mwatson & Jordan Taylor
 *
 */

public class BasketController {
	@Inject
	private OrderLineManager orderLineManger;
	private Order order;
	
	
	public void updateProductQty() 
	{ 
		
	}
	
	public void updatePorousware() 
	{
	}
	
	public void removeProduct() 
	{ 
	}
	
}
