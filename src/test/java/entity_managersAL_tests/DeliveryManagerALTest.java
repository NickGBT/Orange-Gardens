package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entity_managers.arraylist.DeliveryManagerAL;
import com.netbuilder.enums.DeliveryStatus;

/**
 * 
 * @author ngilbert
 *
 */

public class DeliveryManagerALTest {
	
	private Delivery testDelivery, testDelivery2,testDelivery3, testDelivery4;
	private DeliveryStatus deliveryStatus;
	private DeliveryManagerAL deliveryManager;
	private ArrayList<Delivery> testArrayDelivery, testArrayDelivery2; 

	@Before
	public void setUp() throws Exception {

		deliveryStatus = DeliveryStatus.Processing;
		testDelivery = new Delivery("AB/BC/CDEF", "BC/DE/EFGH", "Gnome Depot", new BigDecimal(110.5));
		testDelivery2 = new Delivery("14/04/2015", "17/05/2015", "Gnomes 'r' Us", new BigDecimal(340.7));
		testDelivery3 = new Delivery("RQ/VD/2018", "VA/AR/2020", "Gnarly Gnomes", new BigDecimal(230.15));
		testDelivery4 = new Delivery("18/06/2014", "30/07/2015", "Gnome Boutique", new BigDecimal(280.66));
		testArrayDelivery = new ArrayList<Delivery>();
		testArrayDelivery2 = new ArrayList<Delivery>();
	}

	@Test
	public void testPersistDelivery() {
		deliveryManager.persistDelivery(testDelivery);
		testArrayDelivery = deliveryManager.getDeliveries();
		assertEquals(testArrayDelivery.size(), 1);;
	}

	@Test
	public void testPersistDeliveries() {
		testArrayDelivery2.add(testDelivery);
		testArrayDelivery2.add(testDelivery2);
		deliveryManager.persistDeliveries(testArrayDelivery2);
		testArrayDelivery = deliveryManager.getDeliveries();
		assertEquals(testArrayDelivery.size(), 2);;
	}

	@Test
	public void testFindByDatePlaced() {
		testArrayDelivery.add(testDelivery3);
		deliveryManager.persistDelivery(testDelivery3);
		assertEquals(deliveryManager.findByDatePlaced("RQ/VD/2018"), testArrayDelivery);
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
