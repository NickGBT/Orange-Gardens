package com.netbuilder.controllers;

import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author ngilbert
 *
 */
public class OrderStatusController {

	private OrderDetails setOrderStatus;

	// public
	public void moveWishListToBasket() {
		setOrderStatus.moveOrderToBasket();
	}

	public void placeOrder() {
		setOrderStatus.checkoutOrder();
	}
}
