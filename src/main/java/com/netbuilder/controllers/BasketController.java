package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author Jordan Taylor
 *
 */

public class BasketController {
	@Inject
	private OrderLineManager orderLineManger;
	@Inject
	private OrderDetails basketDetails;
	public List<OrderLine> basket;
	
	public List<OrderLine> getBasket()
	{
		basket = basketDetails.getBasket();
		return basket;	
	}
	
	public void updateProductQty(int productId) 
	{ 
		basketDetails.updateBasket(productId);
	}
	
	public void removeProduct(int productId) 
	{ 
		//add into xhtml.. a remove button per item that allows the removal of a basket item at index
	}
	
	public double getTotal()
	{
		return 0;
	}
	
	public double getSubtotal()
	{
		return 0;
	}
	
	public void setItemQuantity()
	{

	}
}
