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
	private OrderDetails basketGetter;
	public List<OrderLine> basket;
	
	public List<OrderLine> getBasket()
	{
		basket = basketGetter.getBasket();
		return basket;	
	}
	
	
	public void updateProductQty() 
	{ 
		int newQuantity = basketGetter.itemQuantity;
		
		
	}
	
	public void updatePorousware() 
	{
		//add into xhtml.. when a user changes yes or no on porousware, update the basket entry
	}
	
	public void removeProduct() 
	{ 
		//add into xhtml.. a remove button per item that allows the removal of a basket item at index
	}
	
}
