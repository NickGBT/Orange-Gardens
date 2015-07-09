package entity_managersAL_tests;

import org.junit.Assert.*;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StockManagerALTest 
{
	private ArrayList<Stock> testArrayStock, testArrayStock2;
	private Product testProduct, testProduct2;
	private Stock testStock, testStock2;
	private int testVariable;
	
	@Before
	public void setUp() throws Exception
	{
		testArrayStock = new ArrayList<Stock>();
		testArrayStock2 = new ArrayList<Stock>();
		testProduct = new Product("the thing", "gnom", 22.00, 4, 4, 5, 60.00, "A gnom");
		testProduct2 = new Product("the other thing", "gnome", 44.00, 8, 5, 2, 320.00, "A gnome");
		testStock = new Stock(testProduct, 4, 3, "Over there", 10, 2, 5);
		testStock2 = new Stock(testProduct2, 5, 4, "Right here", 12, 5, 9);
		testVariable = 0;
	}
	
	@Test
	public void testPersistStock() 
	{
		testArrayStock.clear();
		testArrayStock2.clear();
		testArrayStock.add(testStock);
		assertEquals(testArrayStock.size(), 1);			
	}
	@Test
	public void testPersistArrayStock()
	{
		testArrayStock.clear();
		testArrayStock2.clear();
		testArrayStock2.add(testStock);
		testArrayStock2.add(testStock2);
		testArrayStock.addAll(testArrayStock2);
		assertEquals(testArrayStock2.size(), 2);	
	}

	@Test
	public void testFindByCriticalThreshold() 
	{
		testVariable = testStock.getCriticalThreshold();
		assertEquals(testVariable, 2);
	}

	@Test
	public void testFindByRequiredStock()
	{
		testVariable = testStock.getRequiredStock();
		assertEquals(testVariable, 5);
	}

	@Test
	public void testFindByStockLevel() 
	{
		testVariable = testStock.getStockLevel();
		assertEquals(testVariable, 4);
	}

	@Test
	public void testFindByStockAvailable() 
	{
		testVariable = testStock.getStockAvailable();
		assertEquals(testVariable, 3);
	}

	@Test
	public void testFindByMaxStock()
	{
		testVariable = testStock.getMaxStock();
		assertEquals(testVariable, 10);
	}
	
	/*@Test
	public void testFindByProductID()
	{
		testVariable = testStock.getProduct().getProductId();
		assertEquals(testVariable, 4);
	}*/
	
	@Test
	public void testGetStock()
	{
		testArrayStock.clear();
		testArrayStock2.clear();
		testArrayStock.add(testStock);
		testArrayStock.add(testStock2);
		assertEquals(testArrayStock.size(), 2);
	}
	
	@Test
	public void testUpdateStock()
	{
		testArrayStock.clear();
		testArrayStock2.clear();
		testArrayStock.add(testStock);
		testArrayStock.set(1, testStock2);
		assertEquals(testArrayStock.indexOf(testStock2), 1);
	}
	
	@Test
	public void testRemoveStock()
	{
		testArrayStock.clear();
		testArrayStock2.clear();
		testArrayStock.add(testStock);
		testArrayStock.remove(1);
		assertEquals(testArrayStock.isEmpty(), true); 
	}
}