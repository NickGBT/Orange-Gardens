package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;

/**
 * 
 * @author mwatson
 *
 */

public class BasketController {
	@Inject
	private OrderLineManagerAL orderLineManger;
	
	public void updateProductQty() { 
	orderLineManger.updateOrderLine(orderLine);
	}
	
	public void updatePorouswareQty() {
	}
	
	public void deleteProduct() { 
	}
}
