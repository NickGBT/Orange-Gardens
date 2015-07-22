package com.netbuilder.controllers;

import java.util.ArrayList;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.CustomerUserId;

public class PreviousOrderController {
	
	private OrderManager orderMan;
	private ArrayList<Order> prevOrders = new ArrayList<Order>();
	private OrderStatus orderStatus = OrderStatus.placed;
	
	public ArrayList<Order> getPreviousOrders(){
		
		return orderMan.findPreviousOrders(orderStatus, CustomerUserId.getUid());
	}

}
