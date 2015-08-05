package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.util.ProductDetails;
import com.netbuilder.util.TestData;

/**
 * 
 * @author mwatson llew
 *
 */

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController {

	@Inject
	private ProductManagerAL pm;
	
	@ManagedProperty(value = "#{testData}")
	private TestData testData;
	private ProductDetails productD;
	private Product product;
	private String productId;

	public ProductController(){
		//product = testData.getProduct();
		//pm.persistProduct(product);
	}
	
	public Product getProduct() {
		// product = productD.getProductId();
		
		product = testData.getProduct();
		return product;
	}

	public void addToWishlist() {
		productD.addToWishlist();
	}

	public void addToBasket() {
		productId = FacesContext.getCurrentInstance().getExternalContext().
				getRequestParameterMap().get("productId");
		System.out.println(productId);
		
	}

	/**
	 * @return the testData
	 */
	public TestData getTestData() {
		return testData;
	}

	/**
	 * @param testData
	 *            the testData to set
	 */
	public void setTestData(TestData testData) {
		this.testData = testData;
	}

}
