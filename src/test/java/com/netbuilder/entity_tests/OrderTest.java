package com.netbuilder.entity_tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.netbuilder.entities.Order;
import com.netbuilder.enums.OrderStatus;

/**
 * @author ngilbert
 */

public class OrderTest {
	
	private Order testOrder;
	private int customerID = 75658;
	private int handlerID = 23758725;
	private OrderStatus status;
	private String datePlaced = "AR/VB/HSJA";
	private String dateDispatched = "AY/YY/LMAO";
	private String dateDelivered = "BS/TI/ARHG";
	private String timeToDeliver = "YU:NB";
	private boolean refundAvailable = false;

	@Before
	public void setUp() throws Exception {
			status = OrderStatus.cancelled;
			testOrder = new Order(customerID, handlerID, status,
			datePlaced, dateDispatched, dateDelivered,
			timeToDeliver, refundAvailable);
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(testOrder.getCustomerID(), customerID);
	}

	@Test
	public void testGetDatePlaced() {
		assertEquals(testOrder.getDatePlaced(), datePlaced);
	}

	@Test
	public void testGetTimeToDeliver() {
		assertEquals(testOrder.getTimeToDeliver(), timeToDeliver);
	}

	@Test
	public void testIsRefundAvailable() {
		assertEquals(testOrder.isRefundAvailable(), refundAvailable);
	}

	@Test
	public void testGetDateDispatched() {
		assertEquals(testOrder.getDateDispatched(), dateDispatched);
	}

	@Test
	public void testGetDateDelivered() {
		assertEquals(testOrder.getDateDelivered(), dateDelivered);
	}

	@Test
	public void testGetHandlerID() {
		assertEquals(testOrder.getHandlerID(), handlerID);
	}
	
	@Test
	public void testOrderStatus()
	{
		assertEquals(OrderStatus.cancelled, status);
	}

}
