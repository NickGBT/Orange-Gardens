package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author Jordan Taylor
 *
 */

public class BasketController 
{
	@Inject
	private OrderManager basketManager;
	private double subtotal, total;
	
	public List<OrderLine> getBasket()
	{
		basket = basketManager.findBasket(status, customerId)
		return basket;	
	}
	
	public void updateProductQty(int productId) 
	{ 

	}
	
	public void removeBasketItem(int productId) 
	{ 	//functionality needs to be added to remove an orderline from an order
		//basketDetails.removeBasketItem(productId);
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public double getSubtotal(int productId)
	{
		return subtotal;
	}
	
	public void setItemQuantity(int newItemQuantity)
	{
	}
}
