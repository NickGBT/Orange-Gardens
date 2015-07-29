package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author Jordan Taylor
 *
 */

public class BasketController 
{
	@Inject
	private OrderDetails basketDetails;
	public List<OrderLine> basket;
	private double subtotal, total;
	
	public List<OrderLine> getBasket()
	{
		basket = basketDetails.getBasket();
		return basket;	
	}
	
	public void updateProductQty(int productId) 
	{ 
		basketDetails.updateBasketQuantity(productId);
	}
	
	public void removeBasketItem(int productId) 
	{ 	//functionality needs to be added to remove an orderline from an order
		//basketDetails.removeBasketItem(productId);
	}
	
	public double getTotal()
	{
		total = basketDetails.getTotal();
		return total;
	}
	
	public double getSubtotal(int productId)
	{
		subtotal = basketDetails.getItemSubtotal(productId);
		return subtotal;
	}
	
	public void setItemQuantity(int newItemQuantity)
	{
		basketDetails.setItemQuantity(newItemQuantity);
	}
}
