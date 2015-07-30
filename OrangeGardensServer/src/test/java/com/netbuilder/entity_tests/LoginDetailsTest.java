package com.netbuilder.entity_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author jtaylor
 *
 */

public class LoginDetailsTest 
{
	private LoginDetails testLoginDetails;
	
	byte[] testPassword1 = {1,2,3};
	byte[] testSalt1 = {1,2,3};
	
	@Before
	public void setUp() throws Exception
	{
		testLoginDetails = new LoginDetails(123, "testUser1", "testEmail1", testPassword1, testSalt1);
	}
	
	@Test
	public void testGetUserId()
	{
		assertEquals(testLoginDetails.getUserId(), 123);
	}
	
	@Test
	public void testGetUsername()
	{
		assertEquals(testLoginDetails.getUsername(), "testUser1");
	}
	
	@Test
	public void testGetEmail()
	{
		assertEquals(testLoginDetails.getEmail(), "testEmail1");
	}
	
	@Test
	public void testGetPassword()
	{
		assertEquals(testLoginDetails.getPassword(), testPassword1);
	}
	
	@Test
	public void testGetSalt()
	{
		assertEquals(testLoginDetails.getSalt(), testSalt1);
	}
}
