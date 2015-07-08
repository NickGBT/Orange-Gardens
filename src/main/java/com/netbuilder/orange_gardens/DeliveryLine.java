package com.netbuilder.orange_gardens;

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
	private int productID;
	
	@ManyToOne
	@JoinColumn(name = "deliveryID", nullable = false)
	@NotNull
	private int deliveryID;
	
	@Column (name = "quantity", nullable = false)
	@NotNull
	private int quantity;
	

	public DeliveryLine(int productID, int deliveryID, int quantity) {
		this.productID = productID;
		this.deliveryID = deliveryID;
		this.quantity = quantity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}
	

}
