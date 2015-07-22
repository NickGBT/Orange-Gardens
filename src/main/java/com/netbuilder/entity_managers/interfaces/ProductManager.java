package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.Product;

/**
 * 
 * @author Alexander Neil
 *
 */

public interface ProductManager{ 
	
	//CREATE
	public void persistProduct(Product product);
	public void persistProducts(List<Product> products);
	
	//READ
	public List<Product> getAll();
	public Product findByProductId(int productId);
	public List<Product> findProductsByName(String name);
	public List<Product> findProductsByPriceBetween(double lowPrice, double highPrice);
	
	//UPDATE
	public void updateProduct(Product product);
	
	//DELETE
	public void removeProduct(Product product);
}