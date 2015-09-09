package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;
import com.netbuilder.entity_managers.arraylist.StockManagerAL;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockManagerALTest {
	private List<Stock> testArrayStock, testArrayStock2;
	private Product testProduct, testProduct2;
	private Stock testStock, testStock2;
	private StockManagerAL stockManager;

	@Before
	public void setUp() throws Exception {
		stockManager = new StockManagerAL();
		testArrayStock = new ArrayList<Stock>();
		testArrayStock2 = new ArrayList<Stock>();
		testProduct = new Product("the thing", "gnom", 22.00, 4, 4, 5, 60.00,
				"A gnom", ProductCategory.gnome);
		testProduct2 = new Product("the other thing", "gnome", 44.00, 8, 5, 2,
				320.00, "A gnome", ProductCategory.gnome);
		testStock = new Stock(testProduct, 4, 3, "Over there", 10, 2, 5, 10, 10);
		testStock2 = new Stock(testProduct2, 5, 4, "Right here", 12, 5, 9, 11, 11);
	}

	@Test
	public void testPersistStock() {
		stockManager.persistStock(testStock);
		testArrayStock = stockManager.getStock();
		assertEquals(testArrayStock.size(), 1);
	}

	@Test
	public void testPersistArrayStock() {

		testArrayStock.add(testStock);
		testArrayStock.add(testStock2);
		stockManager.persistStock(testArrayStock);
		testArrayStock2 = stockManager.getStock();
		assertEquals(testArrayStock2.size(), 2);
	}

	@Test
	public void testFindByCriticalThreshold() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testStock);
		assertEquals(stockManager.findByCriticalThreshold(2), testArrayStock);
	}

	@Test
	public void testFindByRequiredStock() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testStock);
		assertEquals(stockManager.findByRequiredStock(5), testArrayStock);
	}

	@Test
	public void testFindByStockLevel() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testStock);
		assertEquals(stockManager.findByStockLevel(4), testArrayStock);
	}

	@Test
	public void testFindByStockAvailable() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testStock);
		assertEquals(stockManager.findByStockAvailable(3), testArrayStock);
	}

	@Test
	public void testFindByMaxStock() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testStock);
		assertEquals(stockManager.findByMaximumStock(10), testArrayStock);
	}

	/*
	 * @Test public void testFindByProductID() { testVariable =
	 * testStock.getProduct().getProductId(); assertEquals(testVariable, 4); }
	 */

	@Test
	public void testGetStock() {
		testArrayStock.add(testStock);
		testArrayStock.add(testStock2);
		stockManager.persistStock(testArrayStock);
		testArrayStock2 = stockManager.getStock();
		assertEquals(stockManager.getStock(), testArrayStock2);
	}

	@Test
	public void testUpdateStock() {
		testArrayStock.add(testStock);
		stockManager.persistStock(testArrayStock);
		stockManager.updateStock(testStock);
		assertEquals(stockManager.getStock(), testArrayStock);
	}

/*	@Test
	public void testRemoveStock() {
		testArrayStock.add(testStock);
		testArrayStock.add(testStock2);
		testArrayStock2.add(testStock);
		stockManager.persistStock(testArrayStock);
		stockManager.removeStock(testStock2);
		assertEquals(stockManager.getStock(), testArrayStock);
	}*/
}
