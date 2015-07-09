package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entities.Product;

/**
 * 
 * @author llew
 *
 */

public class DeliveryLineTest {
	
	private DeliveryLine deliveryLine;
	
	private String imageLocation = "res/products/img/2412.jpg";	
	private String productName = "Test Gnome";
	private double productPrice = 29.99;
	private int width = 20;
	private int length = 20;
	private int height = 35;
	private double weight = 3;
	private String description = "A gnome for testing, should never exist";	
	private Product testProduct;
	
	private String datePlaced = "15/01/2015";
	private String dateToBeDelivered = "18/01/2015";
	private String supplier = "GnomeM8";
	private BigDecimal price = new BigDecimal(50.00);
	private Delivery delivery;
	
	private int quantity = 10;
	
	@Before
	public void setUp() throws Exception {
		
		testProduct = new Product (imageLocation, productName,
				productPrice, width, length, height, weight, description);
		
		delivery = new Delivery(datePlaced, dateToBeDelivered, supplier, price);
		
		deliveryLine = new DeliveryLine(testProduct, delivery, quantity);
	}

	/*@Test
	public void testGetProductID() {
		assertEquals(testProduct.getProductId(), deliveryLine.getProductID());;
	}*/


	@Test
	public void testGetQuantity() {
		assertEquals(quantity, deliveryLine.getQuantity());;
	}


	/*@Test
	public void testGetDeliveryID() {
		assertEquals(delivery.getDeliveryID(), deliveryLine.getDeliveryID());;
	}*/

}
