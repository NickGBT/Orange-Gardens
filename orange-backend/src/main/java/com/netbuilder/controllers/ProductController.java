package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.ProductDetails;
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
	private UserId userId;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Inject
	private ProductManager pm;

	@Inject
	private OrderManager om;

	@Inject
	private ProductDetails productDetails;

	@Inject
	private OrderLineManager olm;

	private Product product;
	private String productId;
	private String temp;
	private int quantity;
	private Product foundProduct;
	private LoginDetails loginDet;
	private OrderLine orderLine;

	private Order orderBasket;
	private Order wishlist;
	
	private static final Logger logger = LogManager.getLogger();
	
	public ProductController() {

	}

	public Product getProduct() {
		// product = productD.getProductId();
		product = pm.findByProductId(productDetails.getId());
		return product;
	}


	 /**
	  * @author jtaylor
	  * 
	  */
	public void addToBasket() {
		
		productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");

		foundProduct = pm.findByProductId(Integer.parseInt(productId));
		quantity = Integer.parseInt(temp);

		loginDet = ldm.findByUserId(userId.getUid());
		
		Order foundOrder = om.findBasketByUserId(OrderStatus.basket, loginDet);

		if (foundOrder != null) {
			if (olm.findByProductInBasket(foundProduct.getProductId()) != null) {
				orderLine = olm.findByProductId(foundProduct.getProductId());
				orderLine = new OrderLine(orderLine.getOrder(), orderLine.getProduct(), (orderLine.getQuantity() + quantity));
				olm.updateOrderLine(orderLine);
			} else { 
				orderLine = new OrderLine(foundOrder, foundProduct, quantity);
				olm.persistOrderLine(orderLine);
			}
		} else {
			orderBasket = new Order(loginDet, OrderStatus.basket);
			om.persistOrder(orderBasket);
			logger.info("Basket not found, creating new basket");
			orderLine = new OrderLine(orderBasket, foundProduct, quantity);
			olm.persistOrderLine(orderLine);			
		}
	}
	
	
	/**
	  * @author jtaylor
	  * 
	  */
	public void addToWishlist() 
	{
		productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");

		foundProduct = pm.findByProductId(Integer.parseInt(productId));

		//System.out.println("Product Controller::Line141:: The user has selected " + quantity +" of item "+ foundProduct.getProductName() + ", Product ID: " + productId);

		loginDet = ldm.findByUsername(userId.getUsername());

		if (om.findBasketByUserId(OrderStatus.wishlist, loginDet) != null) 
		{
			if (olm.findByProductInWishlist(foundProduct.getProductId()) == null) 
			{
				wishlist = om.findBasketByUserId(OrderStatus.wishlist, loginDet);
				orderLine = new OrderLine(wishlist, foundProduct, 0);
				olm.persistOrderLine(orderLine);
			}
		} 
		else 
		{
			wishlist = new Order(loginDet, OrderStatus.wishlist);
			om.persistOrder(wishlist);
			logger.info("Wishlist not found, creating new wishlist");
			orderLine = new OrderLine(wishlist, foundProduct, 0);
			olm.persistOrderLine(orderLine);
		}
	}
	

	/**
	 * @author jtaylor
	 */
	public void updateQuantity() 
	{
		productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");
		
		// System.out.println("ProductController::Line98::" + temp);
		foundProduct = pm.findByProductId(Integer.parseInt(productId));
		quantity = Integer.parseInt(temp);

		// System.out.println("Product Controller::Line100:: The user has selected "
		// + quantity +" of item "+ foundProduct.getProductName() +
		// ", Product ID: " + productId);

		loginDet = ldm.findByUsername(userId.getUsername());

		if (om.findBasketByUserId(OrderStatus.basket, loginDet) != null) {
			if (olm.findByProductId(foundProduct.getProductId()) != null) {
				orderLine = olm.findByProductId(foundProduct.getProductId());
				orderLine = new OrderLine(orderLine.getOrder(),
						orderLine.getProduct(), (quantity));
				olm.updateOrderLine(orderLine);
			}
		}
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

}
