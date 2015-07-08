package com.netbuilder.entities;

/**
 * 
 * @author mwatson
 *
 */

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wishlist")

public class Wishlist {

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private Customer customerID;
	private ArrayList<WishlistLine> wishListLine;

	public Wishlist(Customer customerID, ArrayList<WishlistLine> wishListLine) {
		this.customerID = customerID;
		this.wishListLine = wishListLine;
	}

	/**
	 * @return the customerID
	 */
	public Customer getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the wishListLine
	 */
	public ArrayList<WishlistLine> getWishListLine() {
		return wishListLine;
	}

	/**
	 * @param wishListLine the wishListLine to set
	 */
	public void setWishListLine(ArrayList<WishlistLine> wishListLine) {
		this.wishListLine = wishListLine;
	}

	
}
