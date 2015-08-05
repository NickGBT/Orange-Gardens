package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.util.ProductDetails;
import com.netbuilder.util.TestData;
import com.netbuilder.util.UserId;

/**
 * 
 * @author mwatson llew
 *
 */

@ManagedBean(name = "productController")
@RequestScoped
public class ProductController {

	@Inject
	private UserId userId;
	
	@Inject
	private ProductManagerAL pm;
	
	@ManagedProperty(value = "#{testData}")
	private TestData testData;
	private ProductDetails productD;
	private Product product;
	private String productId;
	private Product foundProduct;
	
	private Order orderBasket;
	
	public ProductController(){
		
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
		System.out.println(userId.getUsername());
		productId = FacesContext.getCurrentInstance().getExternalContext().
				getRequestParameterMap().get("productId");
		foundProduct = pm.findByProductId(Integer.parseInt(productId));
		
		System.out.println(foundProduct.getProductId());
		
		//orderBasket = new Order()
		
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
