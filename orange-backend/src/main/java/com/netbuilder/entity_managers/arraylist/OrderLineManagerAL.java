package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author llew
 *
 */

@Alternative
@Singleton
public class OrderLineManagerAL implements OrderLineManager{

	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public void persistOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}

	public void persistOrderLine(List<OrderLine> orderLine) {
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

	public List<OrderLine> findByOrderId(int orderId) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>();
		for(OrderLine o : orderLines){
			if(o.getOrder().getOrderID() == orderId){
				orderLine.add(o);
			}
		}
		return orderLine;
	}

	public List<OrderLine> findByQuantity(int quantity) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>(); 
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
	
	public List<OrderLine> getOrderLine() {
		return orderLines;
	}

	public void updateOrderLine(OrderLine orderLine) {
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

	public void updateProductLine(OrderLine orderLine) {
		// TODO Auto-generated method stub
		
	}

	public List<OrderLine> getOrderLines(String username){
		ArrayList<OrderLine> userOrderLines = new ArrayList<OrderLine>();
		for(OrderLine o : orderLines){
			if(o.getOrder().getCustomer().getUsername().equals(username) && o.getOrder().getOrderStatus() == OrderStatus.basket){
				userOrderLines.add(o);
			}
		}
		
		return userOrderLines;
	}
	
}
