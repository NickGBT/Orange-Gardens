package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Order;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author mwatson
 *
 */

public interface OrderManager {

		//CREATE
		public void persistWishlist(Order order);
		
		public void persistWishlist(ArrayList<Order> order);
		
		//READ
		public Order findByOrderID(int OrderID);
		public ArrayList<Order> findByStatus(OrderStatus status);
		
		public ArrayList<Order> findByDatePlace(String datePlaced);
		public ArrayList<Order> findByDateDispatched(String dateDispatched);
		public ArrayList<Order> findByDateDelivered(String dateDelivered);
		public ArrayList<Order> findByTwoDatesOrderPlaced(String firstDate, String secondDate);
		public ArrayList<Order> findByTwoDatesOrderDespatched(String firstDate, String secondDate);
		public ArrayList<Order> findByTwoDatesOrderDelivered(String firstDate, String secondDate);
		
		public ArrayList<Order> findByRefundAvailable(Boolean refundAvailable);
		public ArrayList<Order> findByCustomerId(int customerId);
		public ArrayList<Order> findByEmployeeId(int employeeId);
		
		public Order getOrder();
		
		//UPDATE
		public void updateWishList(Order order);
	
}
