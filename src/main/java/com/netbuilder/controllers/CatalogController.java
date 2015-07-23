package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import com.netbuilder.entities.Product;

/**
 * 
 * @author ngilbert
 *
 */

@Named
@RequestScoped
public class CatalogController {

	public ArrayList<Product> productsInCatalog = new ArrayList<Product>();		
}