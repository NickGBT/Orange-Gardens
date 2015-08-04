package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.arraylist.CustomerManagerAL;
import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class CustomerManagerALTest
{
	private CustomerManagerAL customerManager;
	private Customer testCustomer, testCustomer2;
	private List<Customer> testArrayCustomer, testArrayCustomer2;
	private LoginDetailsManagerAL loginDetailsManager;
	private LoginDetails loginDetailsTest1;
	private List<LoginDetails> testArrayLoginDetails;
	byte[] testSalt1;
	byte[] testPassword1; 
	
	
	@Before
	public void setUp() throws Exception
	{
		customerManager = new CustomerManagerAL();
		testArrayCustomer = new ArrayList<Customer>();
		testArrayCustomer2 = new ArrayList<Customer>();
		testCustomer = new Customer("fName1", "lName1", "contactNumber1", true);
		testCustomer2 = new Customer("fName2", "lName2", "contactNumber2", true);
		loginDetailsTest1 = new LoginDetails(123, "testUser1", "testEmail@1", testPassword1, testSalt1);
	}
	
	@Test
	public void testPersistCustomer()
	{
		customerManager.persistCustomer(testCustomer);
		testArrayCustomer = customerManager.getCustomers();
		assertEquals(testArrayCustomer.size(), 1);
	}
	
	@Test
	public void testPersistCustomers()
	{
		testArrayCustomer.add(testCustomer);
		testArrayCustomer.add(testCustomer2);
		customerManager.persistCustomer(testArrayCustomer);
		assertEquals(customerManager.getCustomers(), testArrayCustomer);
	}
	
	@Test 
	public void testFindByFName()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByFName("fName1"), testArrayCustomer);
	}
	
	@Test 
	public void testFindByLName()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByLName("lName1"), testArrayCustomer);
	}
	
	
	@Test
	public void testGetCustomers()
	{
		testArrayCustomer.add(testCustomer);
		testArrayCustomer.add(testCustomer2);
		customerManager.persistCustomer(testArrayCustomer);
		testArrayCustomer2 = customerManager.getCustomers();
		assertEquals(customerManager.getCustomers(), testArrayCustomer2);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		testArrayCustomer.clear();
		customerManager.persistCustomer(testCustomer);
		testCustomer.setfName("updateTest");
		testArrayCustomer.add(testCustomer);
		customerManager.updateCustomer(testCustomer);
		assertEquals(customerManager.findByFName("fName1").get(0).getfName(), testArrayCustomer.get(0).getfName());
	}
	
	@Test
	public void testRemoveCustomer()
	{
		testArrayCustomer.add(testCustomer);
		testArrayCustomer.add(testCustomer2);
		testArrayCustomer2.add(testCustomer);
		customerManager.persistCustomer(testArrayCustomer);
		customerManager.removeCustomer(testCustomer);
		assertEquals(customerManager.getCustomers(), testArrayCustomer);
	}
}