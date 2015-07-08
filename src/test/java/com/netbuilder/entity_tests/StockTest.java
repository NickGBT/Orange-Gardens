package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockTest
{
	private Stock testStock;
	private Product testProduct;
	private int stockLevel = 4;
	private int stockAvailable = 3;
	private String location = "Over there";
	private int maxStock = 10;
	private int criticalThreshold = 2;
	private int requiredStock = 5;
	
	@Before
	protected void setUp() throws Exception 
	{
		testProduct = new Product("the thing", "gnom", 22.00, 4, 4, 5, 60.00, "A gnom");
		testStock = new Stock(testProduct, stockLevel, stockAvailable, location, maxStock, criticalThreshold, requiredStock);
	}
	
	@Test
	public void testGetStockLevel()
	{
		assertEquals(testStock.getStockLevel(), stockLevel);
	}
	
	@Test
	public void testGetStockAvailable()
	{
		assertEquals(testStock.getStockAvailable(), stockAvailable);
	}
	
	@Test
	public void testGetLocation()
	{
		assertEquals(testStock.getLocation(), location);
	}
	
	@Test
	public void testGetMaxStock()
	{
		assertEquals(testStock.getMaxStock(), maxStock);
	}
	
	@Test
	public void testGetCriticalThreshold()
	{
		assertEquals(testStock.getCriticalThreshold(), criticalThreshold);
	}
	
	@Test
	public void testGetRequiredStock()
	{
		assertEquals(testStock.getRequiredStock(), requiredStock);
	}
}
