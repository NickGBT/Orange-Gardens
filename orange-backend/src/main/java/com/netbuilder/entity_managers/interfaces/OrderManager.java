package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author mwatson
 *
 */
@RequestScoped
public interface OrderManager {

	// CREATE
	public void persistOrder(Order order);

	// public void persistOrder(List<Order> order);

	// READ
	public Order findByOrderID(int orderID);

	public Order findByStatusAndId(OrderStatus status, int customerId);
	
	public List<Order> findByStatus(OrderStatus status);

	public List<Order> findByDatePlaced(String datePlaced);

//	public List<Order> findByDatePlacedInMillis(long datePlacedInMillis);

	public List<Order> findByDateDispatched(String dateDispatched);

	public List<Order> findByDateDelivered(String dateDelivered);

	public List<Order> findByTwoDatesOrderPlaced(String firstDate,
			String secondDate);

	public List<Order> findByTwoDatesOrderDispatched(String firstDate,
			String secondDate);

	public List<Order> findByTwoDatesOrderDelivered(String firstDate,
			String secondDate);

	public List<Order> findByCustomerId(int customerId);

	public List<Order> findByEmployeeId(int employeeId);

	public List<Order> getAllOrders();

	public Order findBasketByUserId(OrderStatus status, LoginDetails customer);
	
	public List<Order> findPreviousOrders(OrderStatus status, String username);

	// UPDATE
	public void updateOrder(Order order);
}
