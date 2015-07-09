package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;

public class OrderManagerAL implements OrderManager {

	private ArrayList<Order> order = new ArrayList<Order>();
	
	public void persistOrder(Order order) {
		this.order.add(order);
		
	}

	public void persistOrder(ArrayList<Order> order) {
		this.order.addAll(order);
		
	}

	public Order findByOrderID(int orderID) {
		
		for(Order o : order) {
			if(o.getOrderID() == orderID) {
				return o;
			}
		}
		
		return null;
	}

	public ArrayList<Order> findByStatus(OrderStatus status) {
		
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : order) {
			if(o.getOrderStatus() == status) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDatePlaced(String datePlaced) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : order) {
			if(o.getDatePlaced()== datePlaced) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDateDispatched(String dateDispatched) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : order) {
			if(o.getDateDispatched() == dateDispatched) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByDateDelivered(String dateDelivered) {
		ArrayList<Order> orderResults = new ArrayList<Order>(); 
		
		for (Order o : order) {
			if(o.getDateDelivered() == dateDelivered) {
				orderResults.add(o);
			}
		}
		
		return orderResults;
	}

	public ArrayList<Order> findByTwoDatesOrderPlaced(String firstDate, String secondDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> findByTwoDatesOrderDespatched(String firstDate, String secondDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> findByTwoDatesOrderDelivered(String firstDate, String secondDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> findByRefundAvailable(Boolean refundAvailable) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> findByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Order> findByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateWishList(Order order) {
		// TODO Auto-generated method stub
		
	}

}
