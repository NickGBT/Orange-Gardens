package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.orange_gardens.PaymentDetails.CardType;

/**
 * 
 * @author Alexander Neil
 *
 */
public class PaymentDetailsTests {

	CardType type;
	
	String number;
	String name;
	int security;
	String expiry;
	int customerId;
	int orderId;
	
	PaymentDetails testPaymentDetails;

	@Before
	public void setUp() throws Exception {
		type = CardType.AMERICANEXPRESS;
		number = "4412889511254478";
		name = "N B Gardens";
		security = 123;
		expiry = "08/18";
		customerId = 4475;
		orderId = 211475;
		
		testPaymentDetails = new PaymentDetails(type, number, name, security, expiry, customerId, orderId);
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
	public void testGetSecurityNumber() {

		assertEquals(security, testPaymentDetails.getSecurityNumber());
	}

	@Test
	public void testGetExpiryDate() {

		assertEquals(expiry, testPaymentDetails.getExpiryDate());
	}

	/*
	@Test
	public void testGetCustomerId() {
		fail("Not yet implemented");
	}
	*/

}
