package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.util.OrderDetails;

/**
 * 
 * @author ngilbert
 *
 */

// @Named
// @RequestScoped
public class WishlistController {

	private OrderDetails wishlistGetter;
	public List<OrderLine> wishlist;

	@Inject
	public List<OrderLine> getWishlist() {
		wishlist = wishlistGetter.getWishlist();
		return wishlist;
	}

	// add remove from wishlist functionality?
}
