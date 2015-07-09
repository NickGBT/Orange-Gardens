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
		public void persistProductLine(OrderLine productLine);

		public void persistProductLine(ArrayList<OrderLine> productLine);

		// READ
		public OrderLine findByProductId(int productID);
		public OrderLine findByOrderId(int orderId); 
		public OrderLine getProductLine();

		// UPDATE
		public void updateProductLine(OrderLine productLine);

		// DELETE
		public void removeProductLine(OrderLine productLine);
}
