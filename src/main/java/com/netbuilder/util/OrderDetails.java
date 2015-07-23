package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.arraylist.OrderManager;
import com.netbuilder.entity_managers.arraylist.OrderLineManager;
import com.netbuilder.util.UserId;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderDetails {
	
		int customerUserId;
		private Order order; 
		
		private OrderManager orderManager;
		private OrderLineManager orderLineManager;
		public List<OrderLine> associatedOrderLines = new ArrayList<OrderLine>();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Calendar rightNow = Calendar.getInstance();
				
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
		
		public void moveOrderToBasket(){
			
			int wishListId = orderManager.findWishlist(OrderStatus.wishlist, UserId.getUid());
			
			order = orderManager.findByOrderID(wishListId);
			
			order.setStatus(OrderStatus.basket);
			
			orderManager.updateOrder(order);
						
		}
		
		public void checkoutOrder(){
			
			int orderId = orderManager.findWishlist(OrderStatus.basket, UserId.getUid());
			
			order = orderManager.findByOrderID(orderId);
			
			order.setStatus(OrderStatus.placed);
			
			order.setDatePlaced((dateFormat.format(rightNow.getTime())));
			
			orderManager.updateOrder(order);
						
		}

}
