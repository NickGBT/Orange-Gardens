package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

@Named
@RequestScoped
public class ProductDetails {

	int quantity;
	int productId;
	int userId;
	int orderId;
	
	ProductCategory category;
	
	OrderStatus status;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	

	
	
}
