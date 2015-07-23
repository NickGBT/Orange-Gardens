package com.netbuilder.controllers;

import com.netbuilder.util.OrderDetails;

/*
 * 
 * @author ngilbert
 *
 */

public class OrderStatusController {

		private OrderDetails setOrderStatus;
		
		//public 
		public void MoveWishListToBasket(){
			setOrderStatus.moveOrderToBasket();
		}
		
		public void PlaceOrder(){
			setOrderStatus.checkoutOrder();
		}
}
