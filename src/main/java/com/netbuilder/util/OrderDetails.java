package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.util.CustomerUserId;

public class OrderDetails {
	
		int customerUserId;
		
		private OrderManagerAL orderManager;
		private OrderLineManagerAL orderLineManager;
		public List<OrderLine> associatedOrderLines = new ArrayList<OrderLine>();
				
		public List<OrderLine> getWishlist(){
			
			int wishlistId = orderManager.findWishlist(OrderStatus.wishlist, CustomerUserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(wishlistId);	
			
			return associatedOrderLines;
						
		}
		
		public List<OrderLine> getBasket(){
			
			int basketId = orderManager.findWishlist(OrderStatus.basket, CustomerUserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(basketId);	
			
			return associatedOrderLines;
						
		}
}
