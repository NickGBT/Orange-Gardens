package com.netbuilder.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ngilbert
 */
@Entity
@Table
public class BasketLine {

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
	private Product product;

	public BasketLine() {

	}

	public BasketLine(int quantity, int customerID, Product product) {
		this.quantity = quantity;
		this.customerID = customerID;
		this.product = product;
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
	public Product getProductID() {
		return product;
	}

}
