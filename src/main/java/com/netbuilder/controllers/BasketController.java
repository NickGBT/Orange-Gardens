package com.netbuilder.controllers;

import javax.inject.Inject;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;

/**
 * 
 * @author mwatson
 *
 */

public class BasketController {
	@Inject
	private OrderLineManager orderLineManger;
	
	public void updateProductQty() { 
	}
	
	public void updatePorouswareQty() {
	}
	
	public void deleteProduct() { 
	}
}
