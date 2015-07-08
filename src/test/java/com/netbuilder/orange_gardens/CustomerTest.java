package com.netbuilder.orange_gardens;

import junit.framework.TestCase;

public class CustomerTest extends TestCase 
{
	private Customer testCustomer;
	private String fName = "Absolutely";
	private String lName = "Fantastic";
	private String username = "bounce";
	private String password = "EnterpriseArchitecture";
	private String email = "absolutely.fantastic@mailmail.mail";
	private boolean isBlackListed = false;	
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		testCustomer = new Customer(fName, lName, username, password, email, isBlackListed);
	}
	
	public void testGetFName()
	{
		assertEquals(testCustomer.getfName(), fName);
	}
	
	public void testGetLName()
	{
		assertEquals(testCustomer.getlName(), lName);
	}
	
	public void testGetUsername()
	{
		assertEquals(testCustomer.getUsername(), username);
	}
	
	public void testGetPassword()
	{
		assertEquals(testCustomer.getPassword(), password);
	}
	
	public void testGetEmail()
	{
		assertEquals(testCustomer.getEmailAddress(), email);
	}
	
	public void testGetIsBlackListed()
	{
		assertEquals(testCustomer.isBlackListed(), isBlackListed);
	}
}