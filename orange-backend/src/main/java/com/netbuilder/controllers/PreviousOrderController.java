package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.UserId;

/*
 * 
 * @author llew
 *
 */

@ManagedBean(name = "previousOrderController")
@RequestScoped
public class PreviousOrderController {

	@Inject
	private OrderManager orderMan;
	
	@Inject
	private OrderLineManager orderLineMan;

	@Inject
	private UserId userId;
	
	private int currentOrderId;
	ArrayList<Integer> orderIds = new ArrayList<Integer>();
	
	ArrayList<List<OrderLine>> group = new ArrayList<List<OrderLine>>();
	
	int index = 0;
	
	public List<OrderLine> getOrderLines(){
		getPreviousOrders();
		return group.get(index++);
	}
	
	public List<OrderLine> getPreviousOrders() {
		int i = 0;
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		for(Order o: orderMan.getAllOrders()){
			if(o.getOrderStatus() == OrderStatus.placed && 
					o.getCustomer().getUsername().equals(userId.getUsername())) {
				
					System.out.println("Order ID : " + o.getOrderID());
					orderLines = orderLineMan.findByOrderId(o.getOrderID());
					System.out.println("OrderLines : " + orderLines);
					group.add(orderLines);
					}
		}
		
		return orderLines;
	}
	
	public ArrayList<Integer> getOrderIds(){
		
		for(Order o: orderMan.getAllOrders()){
			if(o.getOrderStatus() == OrderStatus.placed && 
					o.getCustomer().getUsername().equals(userId.getUsername())) {
					orderIds.add(o.getOrderID());
			}
		}
		
		return orderIds;
		
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
