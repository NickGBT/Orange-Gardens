package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;
import com.netbuilder.entity_managers.arraylist.AddressManagerAL;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class AddressManagerALTest
{
	private ArrayList<Address> testArrayAddress, testArrayAddress2;
	private Address testAddress, testAddress2;
	private Customer testCustomer, testCustomer2;
	private AddressManagerAL addressManager;
	
	@Before
	public void setUp() throws Exception
	{
		addressManager = new AddressManagerAL();
		testArrayAddress = new ArrayList<Address>();
		testArrayAddress2 = new ArrayList<Address>();
		testAddress = new Address(testCustomer, "house", "absolutely", "fantastic", "pull", "bounce", "cheese", "LEY76R", false);
		testAddress2 = new Address(testCustomer2, "shed", "banter", "hell", "earth", "junit", "java", "ABCDEF", false);
		testCustomer = new Customer("foo", "bar", "foobar", "barfoo", "foo@bar.fb", false);
		testCustomer2 = new Customer("food", "barn", "foobarn", "barfoon", "foon@barn.fbn", false);
	}
	
	@Test
	public void testPersistAddress() 
	{
		addressManager.persistAddress(testAddress);
		testArrayAddress = addressManager.getAddresses();
		assertEquals(testArrayAddress.size(), 1);
	}
	
	@Test
	public void testPersistAddresses() 
	{
		testArrayAddress2.add(testAddress);
		testArrayAddress2.add(testAddress2);
		addressManager.persistAddresses(testArrayAddress2);
		testArrayAddress = addressManager.getAddresses();
		assertEquals(testArrayAddress.size(), 2);
	}
	 
	
	@Test
	public void testFindByPostcode() 
	{
		testArrayAddress.add(testAddress);
		addressManager.persistAddress(testAddress);
		assertEquals(addressManager.findByPostcode("LEY76R"), testArrayAddress);
	}
	
	@Test
	public void testFindByLabel() 
	{
		testArrayAddress.add(testAddress);
		addressManager.persistAddress(testAddress);
		assertEquals(addressManager.findByAddressLabel("house"), testArrayAddress);
	}
	
	/*
	@Test
	public void testFindByCustomerID() 
	{
		assertEquals(testAddress.getCustomer().getCustomerID(), 1);
	}
	*/
	
	@Test
	public void testGetAddresses() 
	{
		testArrayAddress.add(testAddress);
		testArrayAddress.add(testAddress2);
		addressManager.persistAddresses(testArrayAddress);
		testArrayAddress2 = addressManager.getAddresses();
		assertEquals(addressManager.getAddresses(), testArrayAddress2);
	}
	
	@Test
	public void updateAddress() 
	{
		testArrayAddress.add(testAddress);
		addressManager.persistAddresses(testArrayAddress);
		addressManager.updateAddress(testAddress);
		assertEquals(addressManager.getAddresses(), testArrayAddress);
	}
	
	@Test
	public void removeAddress() 
	{
		testArrayAddress.add(testAddress);
		testArrayAddress.add(testAddress2);
		testArrayAddress2.add(testAddress);
		addressManager.persistAddresses(testArrayAddress);
		addressManager.removeAddress(testAddress2);
		assertEquals(addressManager.getAddresses(), testArrayAddress2);
	}
}