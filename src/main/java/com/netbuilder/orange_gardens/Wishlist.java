package com.netbuilder.orange_gardens;

/**
 * 
 * @author mwatson
 *
 */

import java.util.ArrayList;

public class Wishlist {

	public Wishlist(ArrayList<Product> product) {
		this.product = product;
	}

	private int customerID;
	private ArrayList<Product> product;

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the product
	 */
	public ArrayList<Product> getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
}
