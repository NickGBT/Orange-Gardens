package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author llew
 *
 */

public class ProductLineTest {
	
	ProductLine productLine; 
	
	private int orderID = 45321;
	private int productID = 12345;
	private int quantity = 350;

	@Before
	public void setUp() throws Exception {
		productLine = new ProductLine(orderID, productID, quantity);
	}

	@Test
	public void testGetQuantity() {
		assertEquals(productLine.getQuantity(), quantity);
	}

	@Test
	public void testGetOrderID() {
		assertEquals(productLine.getOrderID(), orderID);
	}

	@Test
	public void testGetProductID() {
		assertEquals(productLine.getProductID(), productID);
	}

}
