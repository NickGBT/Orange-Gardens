package com.netbuilder.orange_gardens;

import java.math.BigDecimal;

import junit.framework.TestCase;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class DeliveryTest extends TestCase 
{
	private Delivery testDelivery;
	private DeliveryStatus deliveryStatus;
	private String datePlaced = "Today";
	private String dateToBeDelivered = "Tomorrow";
	private String supplier = "MC Gardens";
	private BigDecimal price = new BigDecimal(11.5);
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		deliveryStatus = deliveryStatus.Processing;
		testDelivery = new Delivery(datePlaced, dateToBeDelivered, supplier, price);
	}
	
	public void testGetDatePlaced()
	{
		assertEquals(testDelivery.getDatePlaced(), datePlaced);
	}
	
	public void testGetDateToBeDelivered()
	{
		assertEquals(testDelivery.getDateToBeDelivered(), dateToBeDelivered);
	}
	
	public void testGetSupplier()
	{
		assertEquals(testDelivery.getSupplier(), supplier);
	}
	
	public void testGetPrice()
	{
		assertEquals(testDelivery.getPrice(), price);
	}
	
	public void testDeliveryStatus()
	{
		assertEquals(DeliveryStatus.Processing, deliveryStatus);
	}
}