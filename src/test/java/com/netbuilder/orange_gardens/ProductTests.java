package com.netbuilder.orange_gardens;

import junit.framework.TestCase;

/**
 * 
 * @author Alexander Neil
 *
 */

public class ProductTests extends TestCase {

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
	
	protected void setUp() throws Exception {
		super.setUp();
		
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

	public void testGetImageLocation() {
		
		assertEquals(testProduct.getImageLocation(), imageLocation);
	}
	
	public void testNoImageLocation(){
		testProduct.setImageLocation(null);
		
		assertNull(testProduct.getImageLocation());
	}
/*
	public void testGetProductId() {

		assertEquals(testProduct.getProductId(), productId);
	}
*/
	public void testGetProductName() {

		assertEquals(testProduct.getProductName(), productName);
	}

	public void testGetProductPrice() {

		assertEquals(testProduct.getProductPrice(), productPrice);
	}

	public void testGetWidth() {

		assertEquals(testProduct.getWidth(), width);
	}

	public void testGetHeight() {

		assertEquals(testProduct.getHeight(), height);
	}

	public void testGetLength() {
		assertEquals(testProduct.getLength(), length);
	}

	public void testGetWeight() {

		assertEquals(testProduct.getWeight(), weight);
	}

	public void testGetDescription() {

		assertEquals(testProduct.getDescription(), description);
	}
	
	public void testUnderlengthName(){
		String testName = "a";
		
		testProduct.setProductName(testName);
		
		assertTrue("Name requires length control. Length is: " + testProduct.getProductName().length()
				,testProduct.getProductName().length() >= 4);
	}
	
	public void testOverlengthName(){
		String testName = "a";
		
		for(int i = 0; i < 46; i++) testName = testName + "a";
		
		testProduct.setProductName(testName);
		
		assertTrue("Name requires length control. Length is: " + testProduct.getProductName().length()
				,testProduct.getProductName().length() <= 45);
	}
	
	public void testNullName(){
		testProduct.setProductName(null);
		
		assertTrue("productName has been allowed to be null.", testProduct.getProductName() != null);
	}
	
	
	public void testOverlengthDescription(){
		String testString = "a";
		for(int i = 0; i < 1001; i++) testString = testString + "a";
		
		testProduct.setDescription(testString);
		
		assertTrue("The test string length should be cropped in Product. It is " + testProduct.getDescription().length()
					,testProduct.getDescription().length() <= 1000);
	}

}
