package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.util.UserId;

/**
 * 
 * @author Jordan Taylor
 *
 */
@ManagedBean(name = "basketController")
@RequestScoped
public class BasketController 
{
	@Inject
	private OrderManager basketManager;
	@Inject
	private UserId userId;
	@Inject
	private OrderLineManager orderLineManager;
	
	private List<OrderLine> basket;
	
	private double subtotal =100.0, total = 100.0;
	
	public List<OrderLine> getOrderBasket()
	{
		basket = orderLineManager.getOrderLines(userId.getUsername());
		return basket;		
	}

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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}		

}
