package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * 
 * @author llew
 *
 */

public class BasketTest {
	
	Basket basket;
	
	private int customerID  = 1254;
	private ArrayList<BasketLine> basketLine = new ArrayList<BasketLine>();

	@Before
	public void setUp() throws Exception {
		basket = new Basket(customerID, basketLine);
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(customerID, basket.getCustomerID());
	}

	@Test
	public void testGetProducts() {
		assertEquals(basketLine, basket.getProducts());
	}

}
