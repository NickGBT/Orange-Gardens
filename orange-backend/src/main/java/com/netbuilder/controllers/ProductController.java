package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
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
	private LoginDetailsManager ldm;
	
	@Inject
	private PaymentDetailsManager pdm;
	
	@Inject
	private UserId userId;
	
	@Inject
	private ProductManager pm;
	
	@Inject
	private OrderManager om;
	
	@Inject
	private ProductDetails productDetails;
	
	@ManagedProperty(value = "#{testData}")
	private TestData testData;
	private ProductDetails productD;
	private Product product;
	private String productId;
	private Product foundProduct;
	private LoginDetails loginDet;
	private PaymentDetails paymentDet;
	
	private Order orderBasket;
	
	public ProductController(){
		
	}
	
	public Product getProduct() {
		// product = productD.getProductId();
		System.out.println(productDetails.getId());
		product = pm.findByProductId(productDetails.getId());
		return product;
	}

	public void addToWishlist() {
		productD.addToWishlist();
	}

	 
	public void addToBasket() {
		productId = FacesContext.getCurrentInstance().getExternalContext().
				getRequestParameterMap().get("productId");
		
        System.out.println("Adding to basket , productID : " + productId);
		foundProduct = pm.findByProductId(Integer.parseInt(productId));
		
		System.out.println(foundProduct.getProductName());
		
		loginDet = ldm.findByUsername(userId.getUsername());
		orderBasket = new Order(loginDet, OrderStatus.basket, null);
	    
		om.persistOrder(orderBasket);
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

	public ProductDetails getProductDetails(){
		return productDetails;
	}
	
	public void setProductDetails(ProductDetails productDetails){
		this.productDetails = productDetails;
	}
}
