package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Delivery;
import com.netbuilder.enums.DeliveryStatus;

/**
 * 
 * @author ngilbert
 *
 */

public class DeliveryManagerALTest {
	
	private Delivery testDelivery;
	private DeliveryStatus deliveryStatus;
	private String datePlaced = "Today";
	private String dateToBeDelivered = "Tomorrow";
	private String supplier = "MC Gardens";
	private BigDecimal price = new BigDecimal(11.5);
	private ArrayList<Delivery> testArrayDelivery;

	@Before
	public void setUp() throws Exception {
		deliveryStatus = DeliveryStatus.Processing;
		testDelivery = new Delivery(datePlaced, dateToBeDelivered, supplier, price);
		testArrayDelivery= new ArrayList<Delivery>();
	}

	@Test
	public void testPersistDelivery() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersistDeliveries() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByDatePlaced() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByDeliveryID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeliveries() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDelivery() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDelivery() {
		fail("Not yet implemented");
	}

}
