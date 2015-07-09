package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;

/**
 * 
 * @author Alexander Neil
 *
 */

public interface ProductManager{ 
	
	//CREATE
	public void persistProduct(Product product);
	public void persistProducts(ArrayList<Product> products);
	
	//READ
	public Product findByProductId(int productId);
	public ArrayList<Product> getProductsByName(String name);
	public ArrayList<Product> getProductsByPriceBetween(double lowPrice, double highPrice);
	
	//UPDATE
	public void updateProduct(Product product);
	
	//DELETE
	public void removeProduct(Product product);
}