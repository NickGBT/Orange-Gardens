package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author llew
 *
 */

public class OrderTest {

	private Order testOrder;
	private String datePlaced = "AR/VB/HSJA";
	private String dateDispatched = "AY/YY/LMAO";
	private String dateDelivered = "BS/TI/ARHG";
	private int timeToDeliver = 40;
	private boolean refundAvailable = false;

	private LoginDetails customer;

	private PaymentDetails paymentDetails;
	private LoginDetails employee;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	private OrderStatus orderStatus;

	@Before
	public void setUp() throws Exception {

		customer = new LoginDetails("customer123", "testEmail1", password, salt);
		employee = new LoginDetails("customer123", "testEmail1", password, salt);

		orderStatus = OrderStatus.cancelled;
		paymentDetails = new PaymentDetails(CardType.visa, "3435634734679447",
				"BOB", 323, "22/07/2020", customer);
		testOrder = new Order(customer, employee, orderStatus, datePlaced,
				dateDispatched, dateDelivered,
				timeToDeliver, refundAvailable, paymentDetails);
	}

	/*
	 * @Test public void testGetCustomerID() {
	 * assertEquals(testOrder.getCustomer(), customerID); }
	 */

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

	/*
	 * @Test public void testGetHandlerID() {
	 * assertEquals(testOrder.getEmployee().getEmployeeId(), handlerID); }
	 */

	@Test
	public void testOrderStatus() {
		assertEquals(testOrder.getOrderStatus(), orderStatus);
	}

}
