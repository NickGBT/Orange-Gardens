package com.netbuilder.entity_tests;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;

import junit.framework.TestCase;

/**
 * 
 * @author Alexander Neil
 *
 */

public class AddressTests extends TestCase {

	private Address testAddress;
	
	String addressLabel = "Test Address";
	
	Customer testCustomer;
	
	String lineOne = "5 Orange Garden";
	String lineTwo = "Ochre Business Park";
	String lineThree = "Ambertown";
	String city = "Orangedon";
	String county = "Coppershire";
	String postcode = "QW1 2ER";
	
	String country = "United Kingdom";
	
	protected void setUp() throws Exception {
		super.setUp();
		
		testCustomer = new Customer("foo", "bar", "foobar", "barfoo", "foo@bar.fb", false);
		
		testAddress = new Address(testCustomer, addressLabel, lineOne, lineTwo, lineThree, city, county, postcode, false);
	}

	public void testGetCustomerID() {
		assertEquals(testAddress.getCustomerID(), testCustomer);
	}

	public void testGetAddressLabel() {
		assertEquals(testAddress.getAddressLabel(), addressLabel);
	}
/*
	public void testGetOrderID() {
		fail("Not yet implemented");
	}
*/
	public void testGetAddressLine1() {
		
	
		assertEquals(testAddress.getAddressLine1(), lineOne);
	}

	public void testGetAddressLine2() {
		

		assertEquals(testAddress.getAddressLine2(), lineTwo);
	}

	public void testGetAddressLine3() {
				
		assertEquals(testAddress.getAddressLine3(), lineThree);
	}

	public void testGetCounty() {
				
		assertEquals(testAddress.getCounty(), county);
	}

	public void testGetPostcode() {
		
		assertEquals(testAddress.getPostcode(), postcode);
	}

	public void testIsBillingAddress() {
			
		assertFalse(testAddress.isBillingAddress());
	}

}
