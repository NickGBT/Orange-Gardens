package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	Order testOrder;

	private int customerID = 43521;
	private String datePlaced = "AB/BC/CDEF";
	private String timeToDeliver = "EF:GE";
	private Boolean refundAvailable = false;
	private String dateDispatched = "DE/CA/BEAF";
	private String dateDelivered = "AA/EY/LMAO";
	private OrderStatus status = OrderStatus.cancelled;
	private int orderID = 36346;
	private int handlerID = 234256;

	@Before
	public void setUp() throws Exception {
		testOrder = new Order(customerID, handlerID, status, datePlaced,
				dateDispatched, dateDelivered, timeToDeliver, refundAvailable);
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(customerID, testOrder.getCustomerID());
		;
	}
	
	@Test
	public void testStatus() {
		assertEquals(status, OrderStatus.cancelled);
		;
	}

	@Test
	public void testGetDatePlaced() {
		assertEquals(datePlaced, testOrder.getDatePlaced());
	}

	@Test
	public void testGetTimeToDeliver() {
		assertEquals(timeToDeliver, testOrder.getTimeToDeliver());
	}

	@Test
	public void testIsRefundAvailable() {
		assertEquals(refundAvailable, testOrder.isRefundAvailable());
	}

	@Test
	public void testGetDateDispatched() {
		assertEquals(dateDispatched, testOrder.getDateDispatched());
	}

	@Test
	public void testGetDateDelivered() {
		assertEquals(dateDelivered, testOrder.getDateDelivered());
	}

	@Test
	public void testGetOrderID() {
		assertEquals(orderID, testOrder.getOrderID());
	}

	@Test
	public void testGetHandlerID() {
		assertEquals(handlerID, testOrder.getHandlerID());
	}

}
