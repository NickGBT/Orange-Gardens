package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Wishlist;

/**
 * 
 * @author mwatson
 *
 */


public interface WishlistManager {

	//CREATE
	public void persistWishlist(Wishlist wishList);
	
	public void persistWishlist(ArrayList<Wishlist> wishList);
	
	//READ
	public Wishlist findByCustomerID(int customerID);
	
	public Wishlist getWishList(); 
	
	//UPDATE
	public void updateWishList(Wishlist wishList);
	
	//DELETE 
	public void removeWishList(Wishlist wishList);
}
