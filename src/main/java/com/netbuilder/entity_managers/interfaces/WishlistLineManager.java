package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.WishlistLine;

public interface WishlistLineManager {

	/**
	 * 
	 * @author ngilbert
	 *
	 */

	public interface WishlistManagerLine {

		// CREATE
		public void persistWishlistLine(WishlistLine wishListLine);

		public void persistWishlistLine(ArrayList<WishlistLine> wishListLine);

		// READ
		public WishlistLine findByCustomerID(int customerID);

		public WishlistLine getWishListLine();

		// UPDATE
		public void updateWishListLine(WishlistLine wishListLine);

		// DELETE
		public void removeWishListLine(WishlistLine wishListLine);
	}

}
