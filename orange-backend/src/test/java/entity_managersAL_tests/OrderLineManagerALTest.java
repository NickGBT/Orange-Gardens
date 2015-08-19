package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author llew
 *
 */

public class OrderLineManagerALTest {

	private OrderLineManagerAL orderLineManager;
	private Order order;
	private LoginDetails testCustomer1;
	private PaymentDetails paymentDetails;
	private OrderLine orderLine;
	private OrderLine orderLine1;
	private Product product;
	private Product product2;
	private List<OrderLine> orderlineAL;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	@Before
	public void setUp() throws Exception {

		orderlineAL = new ArrayList<OrderLine>();

		testCustomer1 = new LoginDetails("fooUser", "testEmail1", password,
				salt);

		paymentDetails = new PaymentDetails(CardType.visa, "3435634734679447",
				"BOB", "22/07/2020", testCustomer1);

		orderLineManager = new OrderLineManagerAL();
		order = new Order(testCustomer1, OrderStatus.basket, paymentDetails);

		product = new Product(1, "img/iomg", "testproduct", 25.25, 10, 10, 11,
				10.50, "test Product", ProductCategory.accessory);
		product2 = new Product(2, "img/iomg", "testproduct2", 25.25, 10, 10,
				11, 10.50, "test Product2", ProductCategory.accessory);

		orderLine = new OrderLine(order, product, 50);
		orderLine1 = new OrderLine(order, product2, 50);
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

	/*
	 * @Test public void testFindByProductId() { orderlineAL.clear();
	 * orderlineAL.add(orderLine);
	 * orderLineManager.persistOrderLine(orderlineAL);
	 * assertEquals(orderLineManager.findByProductId(2123), orderLine); }
	 */

	/*
	 * @Test public void testFindByOrderId() { orderlineAL.clear();
	 * orderlineAL.add(orderLine);
	 * orderLineManager.persistOrderLine(orderlineAL);
	 * assertEquals(orderLineManager.findByOrderId(321), orderLine); }
	 */

	// @Test
	// public void testFindByQuantity() {
	// orderlineAL.clear();
	// orderlineAL.add(orderLine);
	// orderLineManager.persistOrderLine(orderlineAL);
	// assertEquals(orderLineManager.findByQuantity(50), orderLine);
	// }

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
	public void testUpdateOrderLine() {
		orderlineAL.clear();
		orderlineAL.add(orderLine);
		orderLineManager.persistOrderLine(orderLine);
		orderLine = new OrderLine(order, product, 1);
		orderLineManager.updateOrderLine(orderLine);
		assertEquals(orderLineManager.getOrderLine().get(0).getQuantity(), 1);
	}

	@Test
	public void testRemoveProductLine() {
		ArrayList<OrderLine> oLine = new ArrayList<OrderLine>();
		orderlineAL.clear();
		orderlineAL.add(orderLine);
		orderlineAL.add(orderLine1);
		oLine.add(orderLine);
		orderLineManager.persistOrderLine(orderLine1);
		orderLineManager.persistOrderLine(orderLine);
		orderLineManager.removeProductLine(orderLine1);
		assertEquals(orderLineManager.getOrderLine().get(0), oLine.get(0));
	}

}
