package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;

/*
 * 
 * @author llew
 *
 */

public class HomepageController {
	
	@Inject
	private ProductManagerAL pmal;
	
	public List<Product> getNewProducts(){
		return pmal.findNewProducts();
		}
	
	
}
