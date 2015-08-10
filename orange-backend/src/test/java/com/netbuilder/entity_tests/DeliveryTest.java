package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Delivery;
import com.netbuilder.enums.DeliveryStatus;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class DeliveryTest {
	private Delivery testDelivery;
	private DeliveryStatus deliveryStatus;
	private String datePlaced = "Today";
	private String dateToBeDelivered = "Tomorrow";
	private String supplier = "MC Gardens";
	private BigDecimal price = new BigDecimal(11.5);

	@Before
	public void setUp() throws Exception {
		deliveryStatus = DeliveryStatus.Processing;
		testDelivery = new Delivery(datePlaced, dateToBeDelivered, supplier,
				price);
	}

	@Test
	public void testGetDatePlaced() {
		assertEquals(testDelivery.getDatePlaced(), datePlaced);
	}

	@Test
	public void testGetDateToBeDelivered() {
		assertEquals(testDelivery.getDateToBeDelivered(), dateToBeDelivered);
	}

	@Test
	public void testGetSupplier() {
		assertEquals(testDelivery.getSupplier(), supplier);
	}

	@Test
	public void testGetPrice() {
		assertEquals(testDelivery.getPrice(), price);
	}

	@Test
	public void testDeliveryStatus() {
		assertEquals(DeliveryStatus.Processing, deliveryStatus);
	}
}