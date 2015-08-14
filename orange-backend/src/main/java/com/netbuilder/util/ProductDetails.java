package com.netbuilder.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author mwatson llew
 *
 */

@Named
@SessionScoped
public class ProductDetails implements Serializable {

	private PaymentDetails paymentD;
	private int quantity;
	private int productId;
	private int customerId;
	private int orderId;
	private String productName;
	private ProductCategory category;
	private OrderStatus status;
	private ProductManager productMan;
	private PaymentDetailsManager paymentMan;
	private OrderManager orderMan;
	private OrderLineManager orderLineMan;
	private Product product;
	private Order order;
	private OrderLine orderLine;
	private LoginDetailsManager loginMan;
	private LoginDetails loginD;

	public void setId(int productId) {
		this.productId = productId;
	}

	public int getId() {
		return productId;
	}

	public int getProductId() {
		// product = productMan.findByProductId(productId);
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addToWishlist() {

		if (orderMan.findByCustomerId(customerId) == null) {
			order = new Order(1, loginD, OrderStatus.wishlist, paymentD);
			orderLine = new OrderLine(order, product);

			orderMan.persistOrder(order);
			orderLineMan.persistOrderLine(orderLine);

		} else {
			orderLine = new OrderLine(order, product);
			orderLineMan.persistOrderLine(orderLine);
		}

	}

	public void addToBasket() {
		if (orderMan.findByCustomerId(customerId) == null) {

			order = new Order(1, loginD, OrderStatus.basket, paymentD);
			orderLine = new OrderLine(order, product, quantity);

			orderMan.persistOrder(order);
			orderLineMan.persistOrderLine(orderLine);
		} else {
			orderLine = new OrderLine(order, product);
			orderLineMan.persistOrderLine(orderLine);
		}
	}

	/**
	 * @return the paymentD
	 */
	public PaymentDetails getPaymentD() {
		return paymentD;
	}

	/**
	 * @param paymentD
	 *            the paymentD to set
	 */
	public void setPaymentD(int customerId) {
		this.paymentD = paymentMan.findCustomerPaymentDetails(customerId);
	}

	public void findLoginDetails(int customerId) {
		this.loginD = loginMan.findByUserId(customerId);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
