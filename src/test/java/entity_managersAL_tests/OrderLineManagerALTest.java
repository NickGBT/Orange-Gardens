package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author llew
 *
 */

public class OrderLineManagerALTest {
	
	private List<OrderLine> testArrayOrderLine, testArrayOrderLine2;
	private OrderLineManagerAL orderLineManager;
	private Order order;
	private LoginDetails testCustomer1;
	private LoginDetails employee;
	private EmployeeDepartment employeeDepartment;
	private EmployeePermissions employeePermission;
	private OrderStatus orderStatus;
	private OrderLine orderLine;
	private OrderLine orderLine1;
	private Product product;
	private List<OrderLine> orderlineAL;
	byte[] password = {1,2,3};
	byte[] salt = {1,2,3};
	
	
	@Before
	public void setUp() throws Exception {
		
		orderlineAL = new ArrayList<OrderLine>();
		
		testCustomer1 = new LoginDetails("fooUser", password, salt);
		employee = new LoginDetails("fooUser2", password, salt);
		
		orderLineManager = new OrderLineManagerAL();	
		order = new Order(testCustomer1, employee, OrderStatus.awaitingDispatch,
				"10/10/15", "12/10/15", "13/10/15",
				"40", true);
		
		product = new Product("img/iomg", "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);
		
		orderLine = new OrderLine(order , product, 50);
		orderLine1 = new OrderLine(order , product, 50);
		
	}

	@Test
	public void testPersistProductLineOrderLine() {
		orderLineManager.persistOrderLine(orderLine);
		orderlineAL = orderLineManager.getOrderLine();
		assertEquals(1, orderlineAL.size());
		
	}
	

	@Test
	public void testPersistProductLineArrayListOfOrderLine() {
		orderlineAL.clear();
		orderlineAL.add(orderLine);
		orderlineAL.add(orderLine1);
		orderLineManager.persistOrderLine(orderlineAL);
		orderlineAL = orderLineManager.getOrderLine();
		assertEquals(2, orderlineAL.size());
		
	}

	/*@Test
	public void testFindByProductId() {
		orderlineAL.clear();	
		orderlineAL.add(orderLine);
		orderLineManager.persistOrderLine(orderlineAL);
		assertEquals(orderLineManager.findByProductId(2123), orderLine);
	}*/

	/*@Test
	public void testFindByOrderId() {
		orderlineAL.clear();	
		orderlineAL.add(orderLine);
		orderLineManager.persistOrderLine(orderlineAL);
		assertEquals(orderLineManager.findByOrderId(321), orderLine);
	}*/

	@Test
	public void testFindByQuantity() {
		orderlineAL.clear();	
		orderlineAL.add(orderLine);
		orderLineManager.persistOrderLine(orderlineAL);
		assertEquals(orderLineManager.findByQuantity(50), orderLine);
	}

	@Test
	public void testGetProductLine() {
		orderlineAL.clear();
		orderlineAL.add(orderLine);
		orderlineAL.add(orderLine1);
		orderLineManager.persistOrderLine(orderlineAL);
		orderlineAL = orderLineManager.getOrderLine();
		assertEquals(orderLineManager.getOrderLine(), orderlineAL);
	}

	@Test
	public void testUpdateProductLine() {
		orderlineAL.clear();	
		orderlineAL.add(orderLine);
		orderLineManager.persistOrderLine(orderlineAL);
		orderLineManager.updateProductLine(orderLine);
		assertEquals(orderLineManager.getOrderLine(), orderLine);
	}

	@Test
	public void testRemoveProductLine() {
		ArrayList<OrderLine> oLine = new ArrayList<OrderLine>();
		orderlineAL.clear();
		orderlineAL.add(orderLine);
		orderlineAL.add(orderLine1);
		oLine.add(orderLine);
		orderLineManager.persistOrderLine(orderlineAL);
		orderLineManager.removeProductLine(orderLine1);
		assertEquals(orderLineManager.getOrderLine(), oLine);
	}

}
