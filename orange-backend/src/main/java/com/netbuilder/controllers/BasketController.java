package com.netbuilder.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.UserId;

/**
 * 
 * @author Jordan Taylor
 *
 */
@ManagedBean(name = "basketController")
@RequestScoped
public class BasketController {
	@Inject
	private OrderManager basketManager;
	@Inject
	private UserId userId;
	@Inject
	private OrderLineManager orderLineManager;
	@Inject
	private ProductManager pm;
	@Inject
	private LoginDetailsManager ldm;
	@Inject
	private OrderLineManager olm;
	@Inject
	private OrderManager om;

	private List<OrderLine> basket;
	private String productId;
	private String temp;
	private int quantity;
	private LoginDetails loginDet;
	private Product foundProduct;
	private OrderLine orderLine;
	DecimalFormat df = new DecimalFormat("0.00");

	private double subtotal = 0, totalDouble = 0;
	private String total = "";

	public OrderManager getBasketManager() {
		return basketManager;
	}

	public void setBasketManager(OrderManager basketManager) {
		this.basketManager = basketManager;
	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public OrderLineManager getOrderLineManager() {
		return orderLineManager;
	}

	public void setOrderLineManager(OrderLineManager orderLineManager) {
		this.orderLineManager = orderLineManager;
	}

	public List<OrderLine> getBasket() {
		basket = orderLineManager.getOrderLines(userId.getUsername());
		return basket;
	}

	public void setBasket(List<OrderLine> basket) {
		this.basket = basket;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getTotal() {
		for (OrderLine ol : basket) {
			totalDouble += (ol.getProduct().getProductPrice() * ol
					.getQuantity());
		}
		total = df.format(totalDouble);
		// System.out.println("BasketController::Line108::" + total);
		// System.out.println("BasketController::Line109::" +
		// df.format(totalDouble));
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	/*
	 * @author jtaylor
	 */
	public void removeFromBasket() {
		productId = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("productId");

		foundProduct = pm.findByProductId(Integer.parseInt(productId));

		loginDet = ldm.findByUsername(userId.getUsername());

		if (om.findBasketByUsername(OrderStatus.basket, userId.getUsername()) != null) {
			if (olm.findByProductId(foundProduct.getProductId()) != null) {
				orderLine = olm.findByProductId(foundProduct.getProductId());
				olm.removeProductLine(orderLine);
			} else {
				System.out
						.println("BasketController::Line127:: Basket does not contain said item.");
			}
		} else {
			System.out
					.println("BasketController::Line134:: Cannot find user basket.");
		}
	}

}
