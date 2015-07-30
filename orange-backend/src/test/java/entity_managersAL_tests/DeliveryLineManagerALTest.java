package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.DeliveryLineManagerAL;
import com.netbuilder.enums.ProductCategory;

public class DeliveryLineManagerALTest {

	
	private Product product;
	private Delivery delivery;
	private DeliveryLine deliveryLine;
	private DeliveryLine deliveryLine1;
	private DeliveryLineManagerAL deliveryLineManager;
	private List<DeliveryLine> deliveryLineAL;
	private List<DeliveryLine> deliveryLineAL1;
	private List<DeliveryLine> testAL;
	
	@Before
	public void setUp() throws Exception {
		product = new Product("img/iomg", "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);
		delivery = new Delivery("10/10/15", "12/10/15", "GnomeM8", new BigDecimal(22.50));	
		
		deliveryLine = new DeliveryLine(product, delivery, 50);
		deliveryLine1 = new DeliveryLine(product, delivery, 50);
		
		deliveryLineManager = new DeliveryLineManagerAL();
		deliveryLineAL = new ArrayList<DeliveryLine>();
		deliveryLineAL1 = new ArrayList<DeliveryLine>();	
		testAL = new ArrayList<DeliveryLine>();
	}

	@Test
	public void testPersistDeliveryLineDeliveryLine() {
		deliveryLineManager.persistDeliveryLine(deliveryLine);
		deliveryLineAL = deliveryLineManager.getDeliveryLine();
		assertEquals(1, deliveryLineAL.size());
	}

	@Test
	public void testPersistDeliveryLineArrayListOfDeliveryLine() {
		deliveryLineAL.add(deliveryLine);
		deliveryLineAL.add(deliveryLine1);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		testAL = deliveryLineManager.getDeliveryLine();
		assertEquals(testAL.size(), 2);
	}

	@Test
	public void testFindByProductID() {
		fail("Not yet implemented");
	}

	/*@Test
	public void testFindByDeliveryID() {
		deliveryLineAL.clear();	
		deliveryLineAL.add(deliveryLine);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		assertEquals(deliveryLineManager.findByDeliveryID(1010), deliveryLine);
	}*/

	@Test
	public void testFindByQuantity() {
		deliveryLineAL.clear();	
		deliveryLineAL.add(deliveryLine);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		assertEquals(deliveryLineManager.findByQuantity(50), deliveryLine);
	}

	@Test
	public void testGetDeliveryLine() {
		deliveryLineAL.clear();
		deliveryLineAL.add(deliveryLine);
		deliveryLineAL.add(deliveryLine1);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		testAL = deliveryLineManager.getDeliveryLine();
		assertEquals(deliveryLineManager.getDeliveryLine(), deliveryLineAL);
	}

	@Test
	public void testUpdateDeliveryLine() {
		deliveryLineAL.clear();	
		deliveryLineAL.add(deliveryLine);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		deliveryLineManager.updateDeliveryLine(deliveryLine);
		assertEquals(deliveryLineManager.getDeliveryLine(), deliveryLine);
	}

	@Test
	public void testRemoveDeliveryLine() {
		ArrayList<DeliveryLine> devLine = new ArrayList<DeliveryLine>();
		deliveryLineAL.clear();
		deliveryLineAL.add(deliveryLine);
		deliveryLineAL.add(deliveryLine1);
		devLine.add(deliveryLine);
		deliveryLineManager.persistDeliveryLine(deliveryLineAL);
		deliveryLineManager.removeDeliveryLine(deliveryLine1);
		assertEquals(deliveryLineManager.getDeliveryLine(), devLine);
	}

}
