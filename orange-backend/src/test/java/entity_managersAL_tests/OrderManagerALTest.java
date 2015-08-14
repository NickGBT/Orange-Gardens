package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.arraylist.OrderManagerAL;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author mwatson
 *
 */

public class OrderManagerALTest {

	OrderManagerAL orderManager;
	private List<Order> testArrayOrder;
	private Order testOrder, testOrder2, testOrder3, testOrder4;
	private LoginDetails testCustomer, testCustomer2, testCustomer3,
			testCustomer4;
	private LoginDetails testEmployee, testEmployee2;
	private PaymentDetails paymentDetails;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	@Before
	public void setUp() throws Exception {
		orderManager = new OrderManagerAL();
		testArrayOrder = new ArrayList<Order>();
		testCustomer = new LoginDetails("fooUser", "testEmail1", password, salt);
		testEmployee = new LoginDetails("fooUser2", "testEmail2", password,
				salt);
		testCustomer2 = new LoginDetails("fooUser3", "testEmail3", password,
				salt);
		testEmployee2 = new LoginDetails("fooUser4", "testEmail4", password,
				salt);
		testCustomer3 = new LoginDetails("fooUser5", "testEmail5", password,
				salt);
		testCustomer4 = new LoginDetails("fooUser6", "testEmail6", password,
				salt);
		paymentDetails = new PaymentDetails(CardType.VISA, "3435634734679447",
				"BOB", 323, "22/07/2020", testCustomer);
		testOrder = new Order(testCustomer, testEmployee,
				OrderStatus.cancelled, "AR/VB/HSJA", "AR/VB/HELLO",
				"AB/CD/HJKS", 504, false, paymentDetails);
		testOrder2 = new Order(testCustomer2, testEmployee2,
				OrderStatus.awaitingDispatch, "03/04/2015",
				"AR/VB/1999", "AB/CD/4321", 2003, false, paymentDetails);
		testOrder3 = new Order(testCustomer3, testEmployee2,
				OrderStatus.wishlist, "03/04/2015", "AR/VB/1999",
				"AB/CD/4321", 2002, false, paymentDetails);
		testOrder4 = new Order(testCustomer3, testEmployee2,
				OrderStatus.basket, "03/04/2015", "AR/VB/1999",
				"AB/CD/4321", 2001, false, paymentDetails);
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
		assertEquals(testArrayOrder,
				orderManager.findByStatus(OrderStatus.cancelled));
	}

	@Test
	public void testFindByDatePlaced() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder,
				orderManager.findByDatePlaced("AR/VB/HSJA"));
	}

	@Test
	public void testFindByDateDispatched() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder,
				orderManager.findByDateDispatched("AR/VB/HELLO"));
	}

	@Test
	public void testFindByDateDelivered() {
		testArrayOrder.add(testOrder);
		orderManager.persistOrder(testOrder);
		assertEquals(testArrayOrder,
				orderManager.findByDateDelivered("AB/CD/HJKS"));
	}

	@Test
	public void testUpdateOrder() {
		orderManager.persistOrder(testOrder);

		testOrder2.setOrderID(1);

		orderManager.updateOrder(testOrder2);

		assertNotEquals(testOrder2,
				orderManager.findByOrderID(testOrder.getOrderID()));
	}

	@Test
	public void testFindWishlist() {
		int tempUserId = testCustomer3.getUserId();
		testArrayOrder.clear();
		OrderStatus status = OrderStatus.wishlist;

		orderManager.persistOrder(testOrder);
		orderManager.persistOrder(testOrder2);
		orderManager.persistOrder(testOrder3);

		assertEquals(orderManager.findWishlist(status, tempUserId),
				testOrder3.getOrderID());

	}

	@Test
	public void testFindBasket() {
		int tempUserId = testCustomer4.getUserId();
		testArrayOrder.clear();
		OrderStatus status = OrderStatus.basket;

		orderManager.persistOrder(testOrder);
		orderManager.persistOrder(testOrder2);
		orderManager.persistOrder(testOrder4);

		assertEquals(orderManager.findBasket(status, tempUserId), testOrder4);

	}

}
