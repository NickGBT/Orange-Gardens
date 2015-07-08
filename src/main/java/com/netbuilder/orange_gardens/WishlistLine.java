package com.netbuilder.orange_gardens;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * Created by Nick Gilbert
 */
public class WishlistLine {

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	@Column(name = "porousware", nullable = false)
	@NotNull
	private boolean porousware;
	@Column(name = "orderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int orderID;
	@Column(name = "productID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productID;

	public WishlistLine() {

	}

	public WishlistLine(int quantity, boolean porousware, int orderID,
			int productID) {
		this.quantity = quantity;
		this.porousware = porousware;
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
	 * @param set
	 *            porous ware availability
	 */
	public void setPorousware(boolean pware) {
		this.porousware = pware;
	}

	/**
	 * @return if porous ware is available
	 */
	public boolean getPorousware() {
		return porousware;
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
