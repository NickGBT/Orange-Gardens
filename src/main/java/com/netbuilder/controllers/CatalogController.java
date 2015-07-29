package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;

/**
 * 
 * @author ngilbert
 *
 **/

//@Named
//@RequestScoped
public class CatalogController {


	//@Inject
	public ArrayList<Product> productsInCatalog = new ArrayList<Product>();	
	
	
	
}

