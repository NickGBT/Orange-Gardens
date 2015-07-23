package com.netbuilder.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.util.ProductDetails;

/**
 * 
 * @author mwatson
 *
 */

@Named
@RequestScoped
public class ProductController {

	@Inject 
	private ProductDetails productD;
	private Product product;

	
	public Product getProduct(){
		product = productD.getProductId();
		return product;
	}
	
	public void addToBasket(){ 
	}
	
	
	public void addToWishlist(){
	}
	
}
