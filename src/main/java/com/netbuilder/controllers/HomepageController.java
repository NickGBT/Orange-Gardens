package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.util.StoreFrontProducts;

/*
 * 
 * @author llew
 *
 */

public class HomepageController {
	
	@Inject
	private ProductManager pmal;
	private StoreFrontProducts storeFrontProducts;
	
	public List<Product> getNewProducts(){
		return storeFrontProducts.getNewProducts();
		}
}
