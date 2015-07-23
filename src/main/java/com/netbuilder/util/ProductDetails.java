package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
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
	
	private ProductManagerAL productMan;
	private Product product;
	
	public Product getProductId() {
		product = productMan.findByProductId(productId);
		return product;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
