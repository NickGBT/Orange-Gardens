package com.netbuilder.util;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;



public class CatalogProduct extends ResourceSupport{
	private final Product p;
	private ProductManager pm;

	@JsonCreator 
	public CatalogProduct(@JsonProperty("id") String id){
		int parsedId = Integer.parseInt(id);
		p = pm.findByProductId(parsedId);
	}
	
	public Product getProduct(){
		return p;
	}
	
}
