package com.netbuilder.controllers;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> a2826bccfec9d85883b26692e2c5544a6d754099

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
<<<<<<< HEAD
	private ProductDetails productD;
=======
	private ProductManagerAL productManager; 
	
	@Inject
	private OrderLineManagerAL orderManager;
	
>>>>>>> a2826bccfec9d85883b26692e2c5544a6d754099
	private Product product;

	
	public Product getProduct(){
		product = productD.getProductId();
		return product;
	}
	
	public void addToBasket(){ 
	}
<<<<<<< HEAD
	
	
	public void addToWishlist(){
	}
	
}
=======
		
	public void addToWishlist() {
	}
		
	public void addToCatalog(){
		ProductCategory categorySelected;
		if (categorySelected == null){
			products = productManager.getAll();
		}
		
		else{
			products = productManager.findByCategory(categorySelected);
			
			
		}
	}
}

>>>>>>> a2826bccfec9d85883b26692e2c5544a6d754099
