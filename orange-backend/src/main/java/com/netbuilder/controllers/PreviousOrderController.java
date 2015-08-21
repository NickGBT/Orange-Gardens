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
	
	ArrayList<Integer> orderIds = new ArrayList<Integer>();
	
	ArrayList<List<OrderLine>> group = new ArrayList<List<OrderLine>>();
	
	int index = 0;
	int total = 0;
	
	public int getTotal(){

		return total;
	}	
	
	public void setTotal(int index){
		total = 0;
		for(OrderLine o : group.get(index)){
			total += o.getProduct().getProductPrice();
		}

	}
	
	public List<OrderLine> getOrderLines(){
		getPreviousOrders();
		setTotal(index);
		return group.get(index++);
	}
	
	public List<OrderLine> getPreviousOrders()
	{
		List<OrderLine> orderLines = new ArrayList<OrderLine>();
		for(Order o: orderMan.getAllOrders()){
			if(o.getOrderStatus() == OrderStatus.placed && o.getCustomer().getUsername().equals(userId.getUsername())) 
			{
				orderLines = orderLineMan.findByOrderId(o.getOrderId());
				group.add(orderLines);
			}
		}
		
		return orderLines;
	}
	
	public ArrayList<Integer> getOrderIds(){
		
		for(Order o: orderMan.getAllOrders()){
			if(o.getOrderStatus() == OrderStatus.placed && 
					o.getCustomer().getUsername().equals(userId.getUsername())) {
					orderIds.add(o.getOrderId());
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
