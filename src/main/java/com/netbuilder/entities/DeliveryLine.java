package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author llew
 *
 */
@Entity
@Table (name = "delivery_line")
public class DeliveryLine {
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product productID;
	
	@ManyToOne
	@JoinColumn(name = "deliveryID", nullable = false)
	@NotNull
	private Delivery deliveryID;
	
	@Column (name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	

	public DeliveryLine(Product productID, Delivery deliveryID, int quantity) {
		this.productID = productID;
		this.deliveryID = deliveryID;
		this.quantity = quantity;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Delivery getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(Delivery deliveryID) {
		this.deliveryID = deliveryID;
	}
	

}
