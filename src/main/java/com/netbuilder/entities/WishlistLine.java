package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Nick Gilbert
 */
@Entity
@Table
public class WishlistLine {

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private int customerID;
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private int productID;

	public WishlistLine() {

	}

	public WishlistLine(int quantity, boolean porousware, int customerID,
			int productID) {
		this.quantity = quantity;
		this.customerID = customerID;
		this.productID = productID;
	}

	/**
	 * @param set
	 *            the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

}
