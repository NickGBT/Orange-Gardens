package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author Alexander Neil
 *
 */

public class AddressTests {

	private Address testAddress;

	String addressLabel = "Test Address";

	LoginDetails testCustomer;

	String lineOne = "5 Orange Garden";
	String lineTwo = "Ochre Business Park";
	String lineThree = "Ambertown";
	String city = "Orangedon";
	String county = "Coppershire";
	String postcode = "QW12ER";

	String country = "United Kingdom";
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	@Before
	public void setUp() throws Exception {

		testCustomer = new LoginDetails("fooUser", "testEmail1", password, salt);

		testAddress = new Address(testCustomer, addressLabel, lineOne, lineTwo,
				lineThree, city, county, postcode, false);
	}

	@Test
	public void testGetCustomerID() {
		assertEquals(testAddress.getCustomer().getUserId(), testCustomer);
	}

	@Test
	public void testGetAddressLabel() {
		assertEquals(testAddress.getAddressLabel(), addressLabel);
	}

	/*
	 * public void testGetOrderID() { fail("Not yet implemented"); }
	 */
	@Test
	public void testGetAddressLine1() {

		assertEquals(testAddress.getAddressLine1(), lineOne);
	}

	@Test
	public void testGetAddressLine2() {

		assertEquals(testAddress.getAddressLine2(), lineTwo);
	}

	@Test
	public void testGetAddressLine3() {

		assertEquals(testAddress.getAddressLine3(), lineThree);
	}

	@Test
	public void testGetCounty() {

		assertEquals(testAddress.getCounty(), county);
	}

	@Test
	public void testGetPostcode() {

		assertEquals(testAddress.getPostcode(), postcode);
	}

	@Test
	public void testIsBillingAddress() {

		assertFalse(testAddress.isBillingAddress());
	}

}
