package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author llew
 *
 */

@Entity
@Table (name = "product_line")
public class OrderLine {
			
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@NotNull
	private Order orderID;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product productID;

	@Column (name = "quantity", nullable = false)
	@NotNull
	private int quantity;

	public OrderLine(Order orderID, Product productID, int quantity) {
		
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}

	public void setOrderID(Order orderID){
		this.orderID = orderID;
	}
	
	public Order getOrder(){
		return orderID;
	}
	
	public void setProductID(Product productID){
		this.productID = productID;
	}
	
	public Product getProduct(){
		return productID;
	}
}