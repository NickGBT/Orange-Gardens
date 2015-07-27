package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author mwatson & Jordan Taylor
 *
 */

public class BasketController {
	@Inject
	private OrderLineManager orderLineManger;
	private OrderDetails basketGetter;
	public List<OrderLine> basket;
	
	public List<OrderLine> getBasket()
	{
		basket = basketGetter.getBasket();
		return basket;	
	}
	
	
	public void updateProductQty() 
	{ 
		//add into xhtml
	}
	
	public void updatePorousware() 
	{
		//add into xhtml
	}
	
	public void removeProduct() 
	{ 
		//add into xhtml
	}
	
}
