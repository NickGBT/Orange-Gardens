package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Order;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author llew
 *
 */

public class OrderTest {
	
	private Order testOrder;
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
	
	@Before
	public void setUp() throws Exception {
		
		    customerID  = new Customer("Absolutely", "Fantastic", "fantastic3", "absfan", "fantastic@absolutely.com", true);
		    employee = new Employee(empDept.WAREHOUSE, fName, lName, password, empPermisions.WORKER);
		    
		    orderStatus = OrderStatus.cancelled;
		    
			testOrder = new Order(customerID, employee, orderStatus,
			datePlaced, dateDispatched, dateDelivered,
			timeToDeliver, refundAvailable);
	}

	/*@Test
	public void testGetCustomerID() {
		assertEquals(testOrder.getCustomer(), customerID);
	}*/

	@Test
	public void testGetDatePlaced() {
		assertEquals(testOrder.getDatePlaced(), datePlaced);
	}

	@Test
	public void testGetTimeToDeliver() {
		assertEquals(testOrder.getTimeToDeliver(), timeToDeliver);
	}

	@Test
	public void testIsRefundAvailable() {
		assertEquals(testOrder.isRefundAvailable(), refundAvailable);
	}

	@Test
	public void testGetDateDispatched() {
		assertEquals(testOrder.getDateDispatched(), dateDispatched);
	}

	@Test
	public void testGetDateDelivered() {
		assertEquals(testOrder.getDateDelivered(), dateDelivered);
	}

	/*@Test
	public void testGetHandlerID() {
		assertEquals(testOrder.getEmployee().getEmployeeId(), handlerID);
	}*/
	
	@Test
	public void testOrderStatus()
	{
		assertEquals(testOrder.getOrderStatus(), orderStatus);
	}

}
