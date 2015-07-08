package com.netbuilder.orange_gardens;

/**
 * 
 * @author mwatson
 *
 */

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wishlist")

public class Wishlist {

	public Wishlist(ArrayList<Product> product) {
		this.product = product;
	}

	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
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
