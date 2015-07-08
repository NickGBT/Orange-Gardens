package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author llew
 *
 */

public class DeliveryLineTest {
	
	DeliveryLine deliveryLine;
	
	private int productID = 45632;
	private int deliveryID = 4264;
	private int quantity = 250;

	@Before
	public void setUp() throws Exception {
		deliveryLine = new DeliveryLine(productID, deliveryID, quantity);
	}

	@Test
	public void testGetProductID() {
		assertEquals(productID, deliveryLine.getProductID());;
	}


	@Test
	public void testGetQuantity() {
		assertEquals(quantity, deliveryLine.getQuantity());;
	}


	@Test
	public void testGetDeliveryID() {
		assertEquals(deliveryID, deliveryLine.getDeliveryID());;
	}

}
