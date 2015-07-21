package com.netbuilder.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;

/**
 * 
 * @author mwatson
 *
 */

@Named
@RequestScoped
public class ProductPageController {
	@Inject 
	private ProductManagerAL productManager; 
	@Inject
	private OrderLineManagerAL orderManager;
	
	private Product product;
	private Order order;
	
	public Product getProduct() {
		product = productManager.findByProductId(productId);
		
		return product;
	}
	
	public void addToBasket() { 
		orderManager.updateOrderLine(orderLine);
	}
	
	
	public void addToWishlist() {
		orderManager.updateOrderLine(orderLine);
	}
	
}
