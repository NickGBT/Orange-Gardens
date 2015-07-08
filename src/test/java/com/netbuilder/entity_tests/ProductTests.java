package com.netbuilder.entity_tests;

import com.netbuilder.entities.Product;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Alexander Neil
 *
 */

public class ProductTests {

	Product testProduct;
	
	String imageLocation;
	int productId;
	String productName;
	double productPrice;
	int width;
	int length;
	int height;
	double weight;
	String description;
	
	@Before
	protected void setUp() throws Exception {
		
		imageLocation = "res/products/img/2412.jpg";
		productId = 2412;
		productName = "Test Gnome";
		productPrice = 29.99;
		width = 20;
		length = 20;
		height = 35;
		weight = 3;
		description = "A gnome for testing, should never exist";
		
		testProduct = new Product(imageLocation, productName, productPrice, width, height, length, weight, description);
	}

	@Test
	public void testGetImageLocation() {
		
		assertEquals(testProduct.getImageLocation(), imageLocation);
	}
	
	@Test
	public void testNoImageLocation(){
		testProduct.setImageLocation(null);
		
		assertNull(testProduct.getImageLocation());
	}
/*
	public void testGetProductId() {

		assertEquals(testProduct.getProductId(), productId);
	}
*/
	@Test
	public void testGetProductName() {

		assertEquals(testProduct.getProductName(), productName);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetProductPrice() {

		assertEquals(testProduct.getProductPrice(), productPrice);
	}

	@Test
	public void testGetWidth() {

		assertEquals(testProduct.getWidth(), width);
	}

	@Test
	public void testGetHeight() {

		assertEquals(testProduct.getHeight(), height);
	}

	@Test
	public void testGetLength() {
		assertEquals(testProduct.getLength(), length);
	}

	@Test
	public void testGetWeight() {

		assertEquals(testProduct.getWeight(), weight);
	}

	@Test
	public void testGetDescription() {

		assertEquals(testProduct.getDescription(), description);
	}

/*
	@Test
	public void testUnderlengthName(){
		String testName = "a";
		
		testProduct.setProductName(testName);
		
		assertTrue("Name requires length control. Length is: " + testProduct.getProductName().length()
				,testProduct.getProductName().length() >= 4);
	}
	
	@Test
	public void testOverlengthName(){
		String testName = "a";
		
		for(int i = 0; i < 46; i++) testName = testName + "a";
		
		testProduct.setProductName(testName);
		
		assertTrue("Name requires length control. Length is: " + testProduct.getProductName().length()
				,testProduct.getProductName().length() <= 45);
	}
	
	@Test
	public void testNullName(){
		testProduct.setProductName(null);
		
		assertTrue("productName has been allowed to be null.", testProduct.getProductName() != null);
	}
	
	@Test
	public void testOverlengthDescription(){
		String testString = "a";
		for(int i = 0; i < 1001; i++) testString = testString + "a";
		
		testProduct.setDescription(testString);
		
		assertTrue("The test string length should be cropped in Product. It is " + testProduct.getDescription().length()
					,testProduct.getDescription().length() <= 1000);
	}
*/
}
