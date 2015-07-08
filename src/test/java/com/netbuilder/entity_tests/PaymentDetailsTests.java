package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Customer;
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
	int security;
	String expiry;
	Customer customerId;
	Order orderId;
	
	PaymentDetails testPaymentDetails;

	@Before
	public void setUp() throws Exception {
		type = CardType.AMERICANEXPRESS;
		number = "4412889511254478";
		name = "N B Gardens";
		security = 123;
		expiry = "08/18";
		customerId = new Customer("foo", "bar", "barfoo", "foobar", "foo@bar.fb", false);
		orderId = null;
		
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
