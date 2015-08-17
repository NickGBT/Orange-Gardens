package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "delivery_line")
public class DeliveryLine implements Serializable {

	@ManyToOne
	@Id
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product productId;

	@ManyToOne
	@JoinColumn(name = "deliveryId", nullable = false)
	@NotNull
	private Delivery deliveryId;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity;

	public DeliveryLine(Product productId, Delivery deliveryId, int quantity) {
		this.productId = productId;
		this.deliveryId = deliveryId;
		this.quantity = quantity;
	}
	
	public DeliveryLine(){}

	public Product getProduct() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Delivery getDelivery() {
		return deliveryId;
	}

	public void setDeliveryId(Delivery deliveryId) {
		this.deliveryId = deliveryId;
	}

}
