package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.arraylist.OrderManager;
import com.netbuilder.entity_managers.arraylist.OrderLineManager;
import com.netbuilder.util.UserId;

public class OrderDetails {
	
		int customerUserId;
		
		private OrderManager orderManager;
		private OrderLineManager orderLineManager;
		public List<OrderLine> associatedOrderLines = new ArrayList<OrderLine>();
				
		public List<OrderLine> getWishlist(){
			
			int wishlistId = orderManager.findWishlist(OrderStatus.wishlist, UserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(wishlistId);	
			
			return associatedOrderLines;
						
		}
		
		public List<OrderLine> getBasket(){
			
			int basketId = orderManager.findWishlist(OrderStatus.basket, UserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(basketId);	
			
			return associatedOrderLines;
						
		}
}
