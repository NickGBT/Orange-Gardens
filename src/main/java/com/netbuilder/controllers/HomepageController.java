package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
	
	public ArrayList<Product> getNewProducts(){
		return pmal.findNewProducts();
		}
	
	
}
