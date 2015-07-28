package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.util.UserId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author ngilbert
 *
 **/

public class OrderDetails {
	
		int customerUserId;
		private Order order; 
		public int itemQuantity;
		
		private OrderManager orderManager;
		private OrderLineManager orderLineManager;
		private ProductManager productManager;
		public List<OrderLine> associatedOrderLines = new ArrayList<OrderLine>();
		private List<Double> subtotals;
		
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
		
		
		/**
		 * 
		 *  @author Jordan Taylor
		 *  
		 *
		 */
		
		public double getItemSubtotal(int productId)
		{
			double itemSubtotal;
			
			double productPrice =  productManager.findByProductId(productId).getProductPrice();
			
			itemSubtotal = productPrice * itemQuantity;
			
			subtotals.add(itemSubtotal);
						
			return itemSubtotal;
		}
		
		
		/**
		 * 
		 *  @author Jordan Taylor
		 *  
		 */
		public double getTotal()
		{
			double itemTotal = 0;
			
			for (double subtotal : subtotals)
			{
				itemTotal = itemTotal + subtotal;
			}			
			
			return itemTotal;			
		}
		
		
		/**
		 * 
		 * @author Jordan Taylor
		 * 
		 */
		public void updateBasketQuantity(int productId)
		{
			int basketId = orderManager.findWishlist(OrderStatus.basket, UserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(basketId);	
			
			for(OrderLine o : associatedOrderLines)
			{
				if(o.getProduct().getProductId() == productId)
				{
					o.setQuantity(itemQuantity);
				}
			}				
		}
		
		
		
		/**
		 * 
		 * @author Jordan Taylor
		 * 
		 */ //functionality needs to be added to remove from an order
		/*public void removeBasketItem(int productId)
		{
			int basketId = orderManager.findWishlist(OrderStatus.basket, UserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(basketId);	
			
			for(OrderLine o : associatedOrderLines)
			{
				if(o.getProduct().getProductId() == productId)
				{
					o.setQuantity(itemQuantity);
				}
			}				
		}*/ 
		
		
		/**
		 * 
		 * @author Jordan Taylor
		 * 
		 */
		public void setItemQuantity(int newItemQuantity)
		{
			itemQuantity = newItemQuantity;
		}
}
