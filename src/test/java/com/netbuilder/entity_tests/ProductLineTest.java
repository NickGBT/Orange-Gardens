package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductLine;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author llew
 *
 */

public class ProductLineTest {
	
	private Order testOrder;
	private int handlerID = 23758725;
	private String datePlaced = "AR/VB/HSJA";
	private String dateDispatched = "AY/YY/LMAO";
	private String dateDelivered = "BS/TI/ARHG";
	private String timeToDeliver = "YU:NB";
	private boolean refundAvailable = false;

	private Customer customerID;
	
	private EmployeeDepartment empDept;
	private String fName = "Test";
	private String lName = "Employee";
	private String password = "test";
	private EmployeePermissions empPermisions;
	private Employee employee;
	
	private OrderStatus orderStatus;
	
	private Product testProduct;
	
	private String imageLocation = "res/products/img/2412.jpg";
	private int productId = 2412;
	private String productName = "Test Gnome";
	private double productPrice = 29.99;
	private int width = 20;
	private int length = 20;
	private int height = 35;
	private double weight = 3;
	private String description = "A gnome for testing, should never exist";
	
	private ProductLine productLine;

	@Before
	public void setUp() throws Exception {
		customerID  = new Customer("Absolutely", "Fantastic", "fantastic3", "absfan", "fantastic@absolutely.com", true);
	    employee = new Employee(empDept.WAREHOUSE, fName, lName, password, empPermisions.WORKER);
	    
	    orderStatus = OrderStatus.cancelled;
	    
		testOrder = new Order(customerID, employee, orderStatus,
		datePlaced, dateDispatched, dateDelivered,
		timeToDeliver, refundAvailable);
		
		testProduct = new Product(imageLocation, productName, productPrice, width, height, length, weight, description);
		
		productLine = new ProductLine()
	}

	@Test
	public void testGetQuantity() {
		assertEquals(productLine.getQuantity(), quantity);
	}

	@Test
	public void testGetOrderID() {
		assertEquals(productLine.getOrderID(), orderID);
	}

	@Test
	public void testGetProductID() {
		assertEquals(productLine.getProductID(), productID);
	}

}
