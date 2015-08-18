package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.Product;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author Alexander Neil
 *
 */
@RequestScoped
public interface ProductManager {

	// CREATE
	public void persistProduct(Product product);

	public void persistProducts(List<Product> products);

	
	// READ
	public List<Product> getAll();

	public Product findByProductId(int productId);

	public List<Product> findProductsByName(String name);

	public List<Product> findProductsByPriceBetween(double lowPrice, double highPrice);

	public List<Product> findProductsByNameAndCat(ProductCategory category, ArrayList<Product> products);
	
	public List<Product> findByCategory(ProductCategory category);

	// UPDATE
	public void updateProduct(Product product);

	// DELETE
	public void removeProduct(Product product);
}