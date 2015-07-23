package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author Alexander Neil
 *
 */
public class ProductManagerALTests {

	ProductManagerAL productManager;
	
	Product p1;
	Product p2;
	Product p3;
	
	ArrayList<Product> testInput;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productManager = new ProductManagerAL();
		
		p1 = new Product("Trial Gnome", 2.99, 2, 2, 2, 3.5, "A gnome for testing.", ProductCategory.Accessory);
		p2 = new Product("Diamond Sun Lounger", 999.99, 60, 55, 170, 10.6, "A sun lounger covered in diamonds.", ProductCategory.Accessory);
		p3 = new Product("Testing Gnome", 6.99, 3, 4, 3, 4.2, "Another gnome for testing.", ProductCategory.Accessory);
		
		p1.setProductId(1);
		p2.setProductId(2);
		p3.setProductId(3);
		
		testInput = new ArrayList<Product>();
		testInput.add(p1);
		testInput.add(p2);
		testInput.add(p3);
	}

	@Test
	public void testPersistProductAndRetriveById() {

		productManager.persistProduct(p1);
		
		assertEquals(p1, productManager.findByProductId(p1.getProductId()));
	}

	@Test
	public void testPersistProductsAndGetAll(){
		
		productManager.persistProducts(testInput);
		
		assertEquals(testInput.size(), productManager.getAll().size());
	}
	
	@Test
	public void testPersistProductsAndFindByName() {

		productManager.persistProducts(testInput);
		
		List<Product> output = productManager.findProductsByName("Gnome");
		
		assertEquals(2, output.size());
	}

	@Test
	public void testFindProductsByPriceBetween() {

		productManager.persistProducts(testInput);
		
		List<Product> output = productManager.findProductsByPriceBetween(2.00, 6.99);
		
		assertEquals(1, output.size());
	}

	@Test
	public void testUpdateProduct() {

		productManager.persistProduct(p1);
		
		p2.setProductId(1);
		
		productManager.updateProduct(p2);
		
		assertNotEquals(p1, productManager.findByProductId(p1.getProductId()));
	}

	@Test
	public void testRemoveProduct() {
		
		productManager.persistProduct(p1);
		
		productManager.removeProduct(p1);
		
		assertNull(productManager.findByProductId(p1.getProductId()));
	}

}
