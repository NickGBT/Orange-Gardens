package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.BasketLine;
import com.netbuilder.entities.Customer;

import java.util.ArrayList;

/**
 * 
 * @author llew
 *
 */

public class BasketTest {
	
	Basket basket;
	
	private ArrayList<BasketLine> basketLine = new ArrayList<BasketLine>();
	private Customer customerID;

	@Before
	public void setUp() throws Exception {
		customerID  = new Customer("Absolutely", "Fantastic", "fantastic3", "absfan", "fantastic@absolutely.com", true);
		basket = new Basket(customerID, basketLine);
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(customerID.getCustomerID(), basket.getCustomer().getCustomerID());
	}

	@Test
	public void testGetProducts() {
		assertEquals(basketLine, basket.getProducts());
	}

}
