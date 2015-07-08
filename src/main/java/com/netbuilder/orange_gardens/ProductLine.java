package com.netbuilder.orange_gardens;

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
public class ProductLine {
	
		
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@NotNull
	private int orderID;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private int productID;

	@Column (name = "quantity", nullable = false)
	@NotNull
	private int quantity;

	
	public ProductLine(int orderID, int productID, int quantity) {
		
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

	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	
	public int getOrderID(){
		return orderID;
	}
	
	public void setProductID(int productID){
		this.productID = productID;
	}
	
	public int getProductID(){
		return productID;
	}

}
