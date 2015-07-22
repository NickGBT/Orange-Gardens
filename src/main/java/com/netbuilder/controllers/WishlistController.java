package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.entity_managers.interfaces.OrderManager;

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
		public ArrayList<Product> productsInWishlist = new ArrayList<Product>();
		
		public WishlistController(){
			productsInWishlist = orderManager.findWishlist();
		}
}
