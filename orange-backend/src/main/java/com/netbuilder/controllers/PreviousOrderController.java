package com.netbuilder.controllers;

import java.util.List;

import javax.inject.Inject;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.UserId;

/*
 * 
 * @author llew
 *
 */

public class PreviousOrderController {

	private OrderManager orderMan;
	private OrderStatus orderStatus;

	@Inject
	private UserId userId;

	public List<Order> getPreviousOrders() {

		return orderMan.findPreviousOrders( orderStatus, userId.getUsername());
	}

	/*
	 * 
	 * @author ngilbert
	 *
	 */
	public List<Order> getReturnableOrders() {
		
		return orderMan.findPreviousOrders(OrderStatus.dispatched, userId.getUsername());
	}
}
