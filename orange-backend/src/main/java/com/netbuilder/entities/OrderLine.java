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
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product product;

	@Column (name = "quantity", nullable = true)
	@NotNull
	private int quantity;

	public OrderLine(Order order, Product product, int quantity) {
		
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	public OrderLine(Order orderId, Product productId) {
		this.order = orderId;
		this.product = productId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}

	public void setOrderID(Order order){
		this.order = order;
	}
	
	public Order getOrder(){
		return order;
	}
	
	public void setProductID(Product product){
		this.product = product;
	}
	
	public Product getProduct(){
		return product;
	}
}