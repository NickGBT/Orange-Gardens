package com.netbuilder.entity_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.enums.CardType;

/**
 * 
 * @author Alexander Neil
 * 
 */
public class PaymentDetailsTests {

	CardType type;

	String number;
	String name;
	String expiry;
	LoginDetails customer;
	Order orderId;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	PaymentDetails testPaymentDetails;

	@Before
	public void setUp() throws Exception {
		type = CardType.americanexpress;
		number = "4412889511254478";
		name = "N B Gardens";
		expiry = "08/18";
		customer = new LoginDetails("fooUser", "testEmail1", password, salt);
		orderId = null;

		testPaymentDetails = new PaymentDetails(type, number, name, expiry, customer);
	}

	@Test
	public void testGetCardType() {

		assertEquals(type, testPaymentDetails.getCardType());
	}

	@Test
	public void testGetCardNumber() {

		assertEquals(number, testPaymentDetails.getCardNumber());
	}

	@Test
	public void testGetNameOnCard() {

		assertEquals(name, testPaymentDetails.getNameOnCard());
	}

	@Test
	public void testGetExpiryDate() {

		assertEquals(expiry, testPaymentDetails.getExpiryDate());
	}

	/*
	 * @Test public void testGetCustomerId() { fail("Not yet implemented"); }
	 */

}
