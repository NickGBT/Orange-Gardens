package com.netbuilder.orange_gardens;

import junit.framework.TestCase;

/**
 * 
 * @author Alexander Neil
 *
 */

public class AddressTests extends TestCase {

	private Address testAddress;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		testAddress = new Address();
	}

	public void testGetCustomerID() {
		fail("Not yet implemented");
	}

	public void testGetAddressLabel() {
		fail("Not yet implemented");
	}

	public void testGetOrderID() {
		fail("Not yet implemented");
	}

	public void testGetAddressLine1() {
		
		String lineOne = "5 Orange Garden";
		
		testAddress.setAddressLine1(lineOne);
		
		assertEquals(testAddress.getAddressLine1(), lineOne);
	}

	public void testGetAddressLine2() {
		
		String lineTwo = "Ochre Business Park";
		
		testAddress.setAddressLine2(lineTwo);
		
		assertEquals(testAddress.getAddressLine2(), lineTwo);
	}

	public void testGetAddressLine3() {
		
		String lineThree = "Ambertown";
		
		testAddress.setAddressLine3(lineThree);
		
		assertEquals(testAddress.getAddressLine3(), lineThree);
	}

	public void testGetCounty() {
		
		String county = "Coppershire";
		
		testAddress.setCounty(county);
		
		assertEquals(testAddress.getCounty(), county);
	}

	public void testGetPostcode() {

		String postcode = "QW1 2ER";
		
		testAddress.setPostcode(postcode);
		
		assertEquals(testAddress.getPostcode(), postcode);
	}

	public void testGetCountry() {

		String country = "United Kingdom";
		
		testAddress.setCountry(country);
		
		assertEquals(testAddress.getCountry(), country);
	}

	public void testIsBillingAddress() {
		
		testAddress.setBillingAddress(false);
		
		assertFalse(testAddress.isBillingAddress());
	}

}
