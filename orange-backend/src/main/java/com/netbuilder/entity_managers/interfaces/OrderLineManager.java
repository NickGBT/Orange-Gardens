package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import com.netbuilder.entities.OrderLine;


/**
 * 
 * @author mwatson
 *
 */

public interface OrderLineManager {

		// CREATE
		public void persistOrderLine(OrderLine orderLine);

		public void persistOrderLine(List<OrderLine> orderLine);

		// READ
		public OrderLine findByProductId(int productID);
		public List<OrderLine> findByOrderId(int orderId); 
		public List<OrderLine> findByQuantity(int quantity); 
		public List<OrderLine> getOrderLine();

		// UPDATE
		public void updateOrderLine(OrderLine orderLine);

		// DELETE
		public void removeProductLine(OrderLine orderLine);
}