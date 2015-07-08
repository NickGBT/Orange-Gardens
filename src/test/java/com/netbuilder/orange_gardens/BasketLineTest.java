package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasketLineTest {

	BasketLine testLine;
	
	int quantity;
	int custId;
	Product product;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		quantity = 11;
		custId = 2221;
		product = new Product("foo/bar", "barfoo", 123.45, 1, 2, 3, 4.0, "foobar");
		
		testLine = new BasketLine(quantity, custId, product);
	}

	@Test
	public void testGetQuantity() {

		assertEquals(quantity, testLine.getQuantity());
	}

	@Test
	public void testGetProductID() {

		assertEquals(product, testLine.getProductID());
	}

}
