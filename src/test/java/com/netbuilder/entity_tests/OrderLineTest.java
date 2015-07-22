package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;

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
	private String timeToDeliver = "YU:NB";
	private boolean refundAvailable = false;

	private LoginDetails customer;
	
	private EmployeeDepartment empDept;
	private String fName = "Test";
	private String lName = "Employee";
	private EmployeePermissions empPermisions;
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
	
	private OrderLine productLine;
	
	private int quantity = 50;
	byte[] password = {1,2,3};
	byte[] salt = {1,2,3};

	@Before
	public void setUp() throws Exception {
		customer  = new LoginDetails("customer123", password, salt);
	    employee = new LoginDetails("employee123", password, salt);
	    
	    orderStatus = OrderStatus.cancelled;
	    
		testOrder = new Order(customer, employee, orderStatus,
		datePlaced, dateDispatched, dateDelivered,
		timeToDeliver, refundAvailable);
		
		testProduct = new Product(imageLocation, productName, productPrice, width, height, length, weight, description);
		
		productLine = new OrderLine(testOrder, testProduct, quantity);
	}

	@Test
	public void testGetQuantity() {
		assertEquals(productLine.getQuantity(), quantity);
	}
	
	/*
	@Test
	public void testGetOrderID() {
		assertEquals(productLine.getOrder().getOrderID(), orderID);
	}*/

	/*@Test
	public void testGetProductID() {
		assertEquals(productLine.getProduct().getProductId(), productID);
	}*/

}
