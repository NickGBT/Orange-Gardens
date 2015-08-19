package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author llew
 *
 */

public class OrderLineTest {

	private Order testOrder;
	private String datePlaced = "AR/VB/HSJA";
	private String dateDispatched = "AY/YY/LMAO";
	private String dateDelivered = "BS/TI/ARHG";
	private int timeToDeliver = 13;
	private boolean refundAvailable = false;

	private LoginDetails customer;

	private LoginDetails employee;

	private OrderStatus orderStatus;

	private Product testProduct;

	private String imageLocation = "res/products/img/2412.jpg";
	private String productName = "Test Gnome";
	private double productPrice = 29.99;
	private int width = 20;
	private int length = 20;
	private int height = 35;
	private double weight = 3;
	private String description = "A gnome for testing, should never exist";
	private ProductCategory productCategory = ProductCategory.accessory;
	private PaymentDetails paymentDetails;
	private OrderLine productLine;

	private int quantity = 50;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	@Before
	public void setUp() throws Exception {
		customer = new LoginDetails("customer123", "testEmail1", password, salt);
		employee = new LoginDetails("employee123", "testEmail1", password, salt);

		orderStatus = OrderStatus.cancelled;
		paymentDetails = new PaymentDetails(CardType.visa, "3435634734679447",
				"BOB", "22/07/2020", customer);
		testOrder = new Order(customer, employee, orderStatus, datePlaced,
				dateDispatched, dateDelivered,
				timeToDeliver, refundAvailable, paymentDetails);

		testProduct = new Product(imageLocation, productName, productPrice,
				width, height, length, weight, description, productCategory);

		productLine = new OrderLine(testOrder, testProduct, quantity);
	}

	@Test
	public void testGetQuantity() {
		assertEquals(productLine.getQuantity(), quantity);
	}

	/*
	 * @Test public void testGetOrderID() {
	 * assertEquals(productLine.getOrder().getOrderID(), orderID); }
	 */

	/*
	 * @Test public void testGetProductID() {
	 * assertEquals(productLine.getProduct().getProductId(), productID); }
	 */

}
