package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;

/**
 * 
 * @author llew
 *+
 */

public class OrderLineManagerAL implements OrderLineManager{

	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public void persistProductLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}

	public void persistProductLine(ArrayList<OrderLine> orderLine) {
		orderLines.addAll(orderLine);		
	}

	public OrderLine findByProductId(int productID) {
		for(OrderLine o : orderLines){
			if(o.getProduct().getProductId() == productID){
				return o;
			}
		}
		return null;
	}

	public OrderLine findByOrderId(int orderId) {
		for(OrderLine o : orderLines){
			if(o.getOrder().getOrderID() == orderId){
				return o;
			}
		}
		return null;
	}

	public ArrayList<OrderLine> findByQuantity(int quantity) {
		ArrayList<OrderLine> orderLine = new ArrayList<OrderLine>(); 
		for(OrderLine o : orderLine){
			if(o.getQuantity() == quantity){
				orderLine.add(o);
			}
		}
		
		if(orderLine.isEmpty())
			return orderLine;
		else
			return null;
		
	}
	
	public ArrayList<OrderLine> getProductLine() {
		return orderLines;
	}

	public void updateProductLine(OrderLine orderLine) {
		for (OrderLine o : orderLines){
			if(o.getOrder().getOrderID() == orderLine.getOrder().getOrderID()){
				orderLines.set(orderLines.indexOf(o), orderLine);
			}
		}
	}

	public void removeProductLine(OrderLine orderLine) {
		for (OrderLine o : orderLines){
			if(o.getOrder().getOrderID() == orderLine.getOrder().getOrderID()){
				orderLines.remove(orderLines.indexOf(o));
			}
		}
		
	}

	
}