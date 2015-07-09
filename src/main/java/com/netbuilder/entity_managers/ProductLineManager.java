package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.ProductLine;


/**
 * 
 * @author mwatson
 *
 */

public interface ProductLineManager {

		// CREATE
		public void persistProductLine(ProductLine productLine);

		public void persistProductLine(ArrayList<ProductLine> productLine);

		// READ
		public ProductLine findByProductId(int productID);
		public ProductLine findByOrderId(int orderId); 
		public ProductLine getProductLine();

		// UPDATE
		public void updateProductLine(ProductLine productLine);

		// DELETE
		public void removeProductLine(ProductLine productLine);
}
