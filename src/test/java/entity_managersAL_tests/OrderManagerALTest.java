package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author mwatson
 *
 */

public class OrderManagerALTest {

	OrderManagerAL orderManager;
	private ArrayList<Order> testArrayOrder;
	private Order testOrder, testOrder2;
	private Customer testCustomer, testCustomer2;
	private Employee testEmployee, testEmployee2;
	
	
	@Before
	public void setUp() throws Exception {
		orderManager = new OrderManagerAL();
		testArrayOrder = new ArrayList<Order>();
		testCustomer = new Customer("James", "Morpheus", false);
		testEmployee = new Employee(EmployeeDepartment.SALES, "Matt", "Watson", "hello", EmployeePermissions.MANAGER);
		testCustomer2 = new Customer("Phil", "Chivers", false);
		testEmployee2 = new Employee(EmployeeDepartment.SALES, "Alex", "Neil", "aneil@netbuilder.com", EmployeePermissions.WORKER);
		
		testOrder = new Order(testCustomer, testEmployee, OrderStatus.cancelled, "AR/VB/HSJA", "AR/VB/HELLO", "AB/CD/HJKS", "AR/VB/HSJA", false);
		testOrder2 = new Order(testCustomer2, testEmployee2, OrderStatus.awaitingDispatch, "03/04/2015", "AR/VB/1999", "AB/CD/4321", "AR/VB/2001", false);
		testOrder.setOrderID(5);
		testOrder2.setOrderID(10);
	}

	@Test
	public void testPersistOrder() {
		orderManager.persistOrder(testOrder);
		testArrayOrder = orderManager.getAllOrders();
		assertEquals(testArrayOrder.size(), 1);
	}

	@Test
	public void testFindByOrderID() {
		orderManager.persistOrder(testOrder);
		assertEquals(testOrder, orderManager.findByOrderID(5));
	}

	@Test
	public void testFindByStatus() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder, orderManager.findByStatus(OrderStatus.cancelled) );
	}

	@Test
	public void testFindByDatePlaced() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder, orderManager.findByDatePlaced("AR/VB/HSJA"));
	}

	@Test
	public void testFindByDateDispatched() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder, orderManager.findByDateDispatched("AR/VB/HELLO"));
	}

	@Test
	public void testFindByDateDelivered() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder, orderManager.findByDateDelivered("AB/CD/HJKS"));
	}

	@Test
	public void testUpdateOrder() {
		orderManager.persistOrder(testOrder);
		
		testOrder2.setOrderID(1);
		
		orderManager.updateOrder(testOrder2);
		
		assertNotEquals(testOrder2, orderManager.findByOrderID(testOrder.getOrderID()));
	}

}
