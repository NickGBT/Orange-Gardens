package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.util.CustomerUserId;

public class Order {
	
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
