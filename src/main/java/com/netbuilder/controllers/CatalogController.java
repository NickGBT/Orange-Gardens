package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.entity_managers.interfaces.ProductManager;

/**
 * 
 * @author ngilbert
 *
 */

@Named
@RequestScoped
public class CatalogController {
	@Inject
	private ProductManagerAL productManager;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public CatalogController(){
		if (categorySelected == null){
			products = productManager.getAll();
		}
		
		else{
			products = productManager.findByCategory();
		}
	}
}
