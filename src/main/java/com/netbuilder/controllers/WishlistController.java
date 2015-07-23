package com.netbuilder.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.util.Order;

/**
 * 
 * @author ngilbert
 *
 */

@Named
@RequestScoped
public class WishlistController {
	
		private Order wishlistGetter;
		public List<OrderLine> wishlist;
	
		@Inject
		public List<OrderLine> getWishlist(){
			wishlist = wishlistGetter.getWishlist();
			return wishlist;
		}
}
