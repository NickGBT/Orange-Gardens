package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockTest {
	private Stock testStock;
	private Product testProduct;
	private int stockLevel = 4;
	private int stockAvailable = 3;
	private String location = "Over there";
	private int maxStock = 10;
	private int criticalThreshold = 2;
	private int requiredStock = 5;
	private int warehouseX = 13;
	private int warehouseY = 10;
	private ProductCategory productCategory = ProductCategory.accessory;

	@Before
	public void setUp() throws Exception {
		testProduct = new Product("the thing", "gnom", 22.00, 4, 4, 5, 60.00,
				"A gnom", productCategory);
		testStock = new Stock(testProduct, stockLevel, stockAvailable,
				location, maxStock, criticalThreshold, requiredStock,
				warehouseX, warehouseY);
	}

	@Test
	public void testGetStockLevel() {
		assertEquals(testStock.getStockLevel(), stockLevel);
	}

	@Test
	public void testGetStockAvailable() {
		assertEquals(testStock.getStockAvailable(), stockAvailable);
	}

	@Test
	public void testGetLocation() {
		assertEquals(testStock.getLocation(), location);
	}

	@Test
	public void testGetMaxStock() {
		assertEquals(testStock.getMaxStock(), maxStock);
	}

	@Test
	public void testGetCriticalThreshold() {
		assertEquals(testStock.getCriticalThreshold(), criticalThreshold);
	}

	@Test
	public void testGetRequiredStock() {
		assertEquals(testStock.getRequiredStock(), requiredStock);
	}
	
	@Test
	public void testGetWarehouseX() {
		assertEquals(testStock.getWarehouseX(), warehouseX);
	}
	
	@Test
	public void testGetWarehouseY() {
		assertEquals(testStock.getWarehouseY(), warehouseY);
	}
}
