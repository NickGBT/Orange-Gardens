package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;

/**
 * 
 * @author gandrews
 *
 */
public interface WishListManager {

	public void persistWishlist(Wishlist inWishList);
	
	public void updateWishlist(Product inProduct);
	public void updateWishlist(ArrayList<Product> inProductList);
	
	public void removeProduct(Product inProduct);
	public void removeProducts(ArrayList<Product> inProductList);
	
	public ArrayList<Product> findProductByName (String inName);
	public Product findProductByID (int inID);
	public ArrayList<Product> findAll();
}
