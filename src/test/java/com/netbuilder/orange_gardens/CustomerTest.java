package com.netbuilder.orange_gardens;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest
{
	private Customer testCustomer;
	private String fName = "Absolutely";
	private String lName = "Fantastic";
	private String username = "bounce";
	private String password = "EnterpriseArchitecture";
	private String email = "absolutely.fantastic@mailmail.mail";
	private boolean isBlackListed = false;	
	
	@Before
	protected void setUp() throws Exception 
	{
		testCustomer = new Customer(fName, lName, username, password, email, isBlackListed);
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
	public void testGetUsername()
	{
		assertEquals(testCustomer.getUsername(), username);
	}
	
	public void testGetPassword()
	{
		assertEquals(testCustomer.getPassword(), password);
	}
	
	@Test
	public void testGetEmail()
	{
		assertEquals(testCustomer.getEmailAddress(), email);
	}
	
	@Test
	public void testGetIsBlackListed()
	{
		assertEquals(testCustomer.isBlackListed(), isBlackListed);
	}
}