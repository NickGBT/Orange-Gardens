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
	private boolean isBlackListed = false;	
	
	@Before
	protected void setUp() throws Exception 
	{
		testCustomer = new Customer(fName, lName, isBlackListed);
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