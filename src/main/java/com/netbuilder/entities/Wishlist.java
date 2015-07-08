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
	@JoinColumn(name = "customer_id", 
	nullable = false)
	@NotNull
	private int customerID;
	private ArrayList<Product> product;
	
	public Wishlist(int customerID, ArrayList<Product> product) {
		this.customerID = customerID;
		this.product = product;
	}

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
