package com.netbuilder.orange_gardens;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Nick Gilbert
 */
@Entity
@Table
public class BasketLine {

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	@Column(name = "orderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int orderID;
	@Column(name = "productID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productID;

	public BasketLine() {

	}

	public BasketLine(int quantity, boolean porousware, int orderID,
			int productID) {
		this.quantity = quantity;
		this.orderID = orderID;
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
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

}
