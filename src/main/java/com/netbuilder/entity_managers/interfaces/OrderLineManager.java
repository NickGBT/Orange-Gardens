package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.OrderLine;


/**
 * 
 * @author mwatson
 *
 */

public interface OrderLineManager {

		// CREATE
		public void persistProductLine(OrderLine orderLine);

		public void persistProductLine(ArrayList<OrderLine> orderLine);

		// READ
		public OrderLine findByProductId(int productID);
		public OrderLine findByOrderId(int orderId); 
		public ArrayList<OrderLine> findByQuantity(int quantity); 
		public ArrayList<OrderLine> getProductLine();

		// UPDATE
		public void updateProductLine(OrderLine orderLine);

		// DELETE
		public void removeProductLine(OrderLine orderLine);
}
