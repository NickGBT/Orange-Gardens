package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Customer;

public class CustomerTest
{
	private Customer testCustomer;
	private String fName = "Absolutely";
	private String lName = "Fantastic";
	private String contactNumber = "075";
	private boolean isBlackListed = false;	
	
	@Before
	public void setUp() throws Exception 
	{
		testCustomer = new Customer(fName, lName, contactNumber, isBlackListed);
	}
	
	@Test
	public void testGetFName()
	{
		assertEquals(testCustomer.getfName(), fName);
	}
	
	@Test
	public void testGetLName()
	{
		assertEquals(testCustomer.getlName(), lName);
	}
	
	@Test
	public void testGetIsBlackListed()
	{
		assertEquals(testCustomer.isBlackListed(), isBlackListed);
	}
}