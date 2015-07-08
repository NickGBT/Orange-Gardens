package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WishlistLineTest {
	
	WishlistLine wishLine;

	private int quantity = 350;
	private int customerID = 1455;
	private Product product;
	
	@Before
	public void setUp() throws Exception {
		product = new Product("/test/test/test.img", "gnome", 22.00, 4, 4, 5, 60, "gnome init");
		wishLine = new WishlistLine(quantity, customerID, product);
	}

	@Test
	public void testGetQuantity() {
		assertEquals(quantity, wishLine.getQuantity());
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(customerID, wishLine.getCustomerID());
	}

	@Test
	public void testGetProductID() {
		assertEquals(product, wishLine.getProductID());
	}

}
