package com.netbuilder.controllers;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author mwatson
 *
 */

@Named
@RequestScoped
public class ProductController {
	@Inject 
	private ProductManagerAL productManager; 
	
	@Inject
	private OrderLineManagerAL orderManager;
	
	private Product product;
	private Order order;
	private List<Product> products;
	public Product getProduct() {
		
		return product;
	}
	
	public void addToBasket() { 
	}
		
	public void addToWishlist() {
	}
		
	public void addToCatalog(){
		ProductCategory categorySelected;
		if (categorySelected == null){
			products = productManager.getAll();
		}
		
		else{
			products = productManager.findByCategory(categorySelected);
			
			
		}
	}
}

