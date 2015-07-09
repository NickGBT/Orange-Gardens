package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entity_managers.arraylist.CustomerManagerAL;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class CustomerManagerALTest
{
	private CustomerManagerAL customerManager;
	private Customer testCustomer, testCustomer2;
	private ArrayList<Customer> testArrayCustomer, testArrayCustomer2;
	
	@Before
	public void setUp() throws Exception
	{
		customerManager = new CustomerManagerAL();
		testArrayCustomer = new ArrayList<Customer>();
		testArrayCustomer2 = new ArrayList<Customer>();
		testCustomer = new Customer("Absolutely", "Fantastic", "bounce", "EnterpriseArchitecture", "absolutely.fantastic@mailmail.mail", false);
		testCustomer2 = new Customer("Billy", "Bob", "bilbo", "baggins", "billy.bob@mailmail.mail", false);
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
		testArrayCustomer2 = customerManager.getCustomers();
		assertEquals(testArrayCustomer2.size(), 2);
	}
	
	@Test 
	void testFindByFName()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByFName("Absolutely"), testArrayCustomer);
	}
	
	@Test 
	void testFindByLName()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByLName("Fantastic"), testArrayCustomer);
	}
	
	@Test 
	void testFindByUsername()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByUsername("bounce"), testArrayCustomer);
	}
	
	@Test
	void testFindByEmail()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testCustomer);
		assertEquals(customerManager.findByEmail("absolutely.fantastic@mailmail.mail"), testArrayCustomer);
	}
	
	@Test
	void testGetCustomers()
	{
		testArrayCustomer.add(testCustomer);
		testArrayCustomer.add(testCustomer2);
		customerManager.persistCustomer(testArrayCustomer);
		testArrayCustomer2 = customerManager.getCustomers();
		assertEquals(customerManager.getCustomers(), testArrayCustomer2);
	}
	
	@Test
	void testUpdateCustomer()
	{
		testArrayCustomer.add(testCustomer);
		customerManager.persistCustomer(testArrayCustomer);
		customerManager.updateCustomer(testCustomer);
		assertEquals(customerManager.getCustomers(), testArrayCustomer);
	}
	
	@Test
	void testRemoveCustomer()
	{
		testArrayCustomer.add(testCustomer);
		testArrayCustomer.add(testCustomer2);
		testArrayCustomer2.add(testCustomer);
		customerManager.persistCustomer(testArrayCustomer);
		customerManager.removeCustomer(testCustomer);
		assertEquals(customerManager.getCustomers(), testArrayCustomer);
	}
}