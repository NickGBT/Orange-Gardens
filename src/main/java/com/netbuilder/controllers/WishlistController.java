package com.netbuilder.controllers;

import java.util.ArrayList;

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

/**
 * 
 * @author ngilbert
 *
 */

@Named
@RequestScoped
public class WishlistController {
		@Inject
		private OrderManagerAL orderManager;
		private OrderLineManagerAL orderLineManager;
		public ArrayList<Product> productsInWishlist = new ArrayList<Product>();
		public ArrayList<OrderLine> associatedOrderLines = new ArrayList<OrderLine>();
				
		public WishlistController(){
			
			int wishlist = orderManager.findWishlist(OrderStatus.wishlist, CustomerUserId.getUid());
			
			associatedOrderLines = orderLineManager.findByOrderId(wishlist);
			
			productsInWishlist = ;
}
