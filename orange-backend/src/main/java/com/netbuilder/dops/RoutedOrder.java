package com.netbuilder.dops;

import java.util.ArrayList;
import java.util.Map;
import java.util.IdentityHashMap;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author ngilbert
 *
 **/

public class RoutedOrder {
	
	private OrderPrioritySystem ops;
	
	private OrderLineManager olm;

	private ArrayList <Order> prioritisedPlacedOrders = (ArrayList<Order>) ops.getPrioritisedQueue();
	
	private Order orderFromQueue = prioritisedPlacedOrders.get(0);
	
	private ArrayList <OrderLine> oFQOrderlines = (ArrayList<OrderLine>) olm.findByOrderId(orderFromQueue.getOrderID());
	
	private Map <Integer, Integer> orderLineValues = new IdentityHashMap<Integer, Integer>();
	
	public Map<Integer, Integer> getOrderLineValues(){
		for(OrderLine oL :oFQOrderlines){
			orderLineValues.put(new Integer(oL.getProduct().getProductId()), new Integer(oL.getQuantity()));
		}
		return orderLineValues;
	}
	
	public void processOrder(){
		
		//placeholder for an employee id to be sent back to the class
		orderFromQueue.setStatus(OrderStatus.processing);
		
		
	}
	
	public void fulfilOrder(){
		
		
		orderFromQueue.setStatus(OrderStatus.dispached);	
		
		
	}

}
