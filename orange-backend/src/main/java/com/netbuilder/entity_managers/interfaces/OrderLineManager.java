package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import com.netbuilder.entities.OrderLine;

/**
 * 
 * @author mwatson
 *
 */
@Named
@RequestScoped
public interface OrderLineManager {

	// CREATE
	public void persistOrderLine(OrderLine orderLine);

	public void persistOrderLine(List<OrderLine> orderLine);

	// READ
	public OrderLine findByProductId(int productID);

	public List<OrderLine> findByOrderId(int orderId);

	public List<OrderLine> findByQuantity(int quantity);

	public List<OrderLine> getOrderLine();

	public List<OrderLine> getOrderLines(String username);

	// UPDATE
	public void updateOrderLine(OrderLine orderLine);

	// DELETE
	public void removeProductLine(OrderLine orderLine);
}
