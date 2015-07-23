package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;

/**
 * 
 * @author mwatson
 *
 */

public class BasketController {
	@Inject
	private OrderLineManagerAL orderLineManger;
	
	public void updateProductQty() { 
	}
	
	public void updatePorouswareQty() {
	}
	
	public void deleteProduct() { 
	}
}
