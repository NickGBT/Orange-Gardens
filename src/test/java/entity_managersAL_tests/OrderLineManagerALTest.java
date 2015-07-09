package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.arraylist.AddressManagerAL;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;

/**
 * 
 * @author llew
 *
 */

public class OrderLineManagerALTest {
	
	private ArrayList<OrderLine> testArrayOrderLine, testArrayOrderLine2;

	@Before
	public void setUp() throws Exception {
		OrderLineManagerAL orderLine = new OrderLineManagerAL();

	}

	@Test
	public void testPersistProductLineOrderLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersistProductLineArrayListOfOrderLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProductId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByQuantity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProductLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveProductLine() {
		fail("Not yet implemented");
	}

}
