package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.util.ProductDetails;
import com.netbuilder.util.TestData;

/**
 * 
 * @author mwatson
 *
 */

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController {

	@ManagedProperty(value = "#{testData}")
	private TestData testData;
	private ProductDetails productD;	
	private Product product;
	
	public Product getProduct(){
	//	product = productD.getProductId();
		product = testData.getProduct();
		return product;
	}
	
	public void addToWishlist() { 
		productD.addToWishlist();
	}
	
	public void addToBasket() { 
		productD.addToBasket();
	}

	/**
	 * @return the testData
	 */
	public TestData getTestData() {
		return testData;
	}

	/**
	 * @param testData the testData to set
	 */
	public void setTestData(TestData testData) {
		this.testData = testData;
	}
	
	
	
}

