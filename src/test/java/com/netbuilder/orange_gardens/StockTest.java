package com.netbuilder.orange_gardens;

import junit.framework.TestCase;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockTest extends TestCase
{
	private Stock testStock;
	private Product testProduct;
	private int stockLevel = 4;
	private int stockAvailable = 3;
	private String location = "Over there";
	private int maxStock = 10;
	private int criticalThreshold = 2;
	private int requiredStock = 5;
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		testProduct = new Product("the thing", 3, "gnom", 22.00, 4, 4, 5, 60.00, "A gnom");
		testStock = new Stock(testProduct, stockLevel, stockAvailable, location, maxStock, criticalThreshold, requiredStock);
	}
	
	public void testGetProductID()
	{
		assertEquals(testProduct.getProductId(), 3);
	}
	
	public void testGetStockLevel()
	{
		assertEquals(testStock.getStockLevel(), stockLevel);
	}
	
	public void testGetStockAvailable()
	{
		assertEquals(testStock.getStockAvailable(), stockAvailable);
	}
	
	public void testGetLocation()
	{
		assertEquals(testStock.getLocation(), location);
	}
	
	public void testGetMaxStock()
	{
		assertEquals(testStock.getMaxStock(), maxStock);
	}
	
	public void testGetCriticalThreshold()
	{
		assertEquals(testStock.getCriticalThreshold(), criticalThreshold);
	}
	
	public void testGetRequiredStock()
	{
		assertEquals(testStock.getRequiredStock(), requiredStock);
	}
}
