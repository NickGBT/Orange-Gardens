package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.Order;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author mwatson
 *
 */

public interface OrderManager {

		//CREATE
		public void persistOrder(Order order);
		
		//public void persistOrder(List<Order> order);
		
		//READ
		public Order findByOrderID(int OrderID);
		public List<Order> findByStatus(OrderStatus status);
		
		public List<Order> findByDatePlaced(String datePlaced);
		public List<Order> findByDatePlacedInMillis(long datePlacedInMillis);
		public int findWishlist (OrderStatus status, int customerId);
		public Order findBasket (OrderStatus status, int customerId);
		public List<Order> findPreviousOrders(OrderStatus status, int customerId);
		public List<Order> findByDateDispatched(String dateDispatched);
		public List<Order> findByDateDelivered(String dateDelivered);
		public List<Order> findByTwoDatesOrderPlaced(String firstDate, String secondDate);
		public List<Order> findByTwoDatesOrderDispatched(String firstDate, String secondDate);
		public List<Order> findByTwoDatesOrderDelivered(String firstDate, String secondDate);
		public List<Order> findByCustomerId(int customerId);
		public List<Order> findByEmployeeId(int employeeId);
		public List<Order> getAllOrders();
		
		//UPDATE
		public void updateOrder(Order order);
	
}
