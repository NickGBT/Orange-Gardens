package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.Product;
<<<<<<< HEAD
import com.netbuilder.entity_managers.arraylist.ProductManager;
=======
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.util.StoreFrontProducts;
>>>>>>> 0b9c72ae1e119cbed00300c5359be248fd8c50b8

/*
 * 
 * @author llew
 *
 */

public class HomepageController {
	
	@Inject
<<<<<<< HEAD
	private ProductManager pmal;
=======
	private StoreFrontProducts storeFrontProducts;
>>>>>>> 0b9c72ae1e119cbed00300c5359be248fd8c50b8
	
	public List<Product> getNewProducts(){
		return storeFrontProducts.getNewProducts();
		}
}
