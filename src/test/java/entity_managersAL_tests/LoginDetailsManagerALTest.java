package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.arraylist.LoginDetailsManagerAL;
import com.netbuilder.util.LoginDetailsToolkit;

/**
 * 
 * @author jtaylor
 *
 */

public class LoginDetailsManagerALTest 
{
	private LoginDetailsManagerAL loginDetailsManager;
	private LoginDetails loginDetailsTest1, loginDetailsTest2;
	private List<LoginDetails> testArrayLoginDetails, testArrayLoginDetails2;
	
	byte[] testSalt1;
	byte[] testPassword1; 
	byte[] testPassword2;
	byte[] testSalt2;
	
	
	@Before
	public void setUp() throws Exception
	{
		testSalt1 = LoginDetailsToolkit.generateSalt();
		testPassword1 = LoginDetailsToolkit.getHashedPassword("testPassword", testSalt1);
		testSalt2 = LoginDetailsToolkit.generateSalt();
		testPassword2 = LoginDetailsToolkit.getHashedPassword("testPassword", testSalt2);
		loginDetailsManager = new LoginDetailsManagerAL();
		testArrayLoginDetails = new ArrayList<LoginDetails>();
		loginDetailsTest1 = new LoginDetails(123, "testUser1", "testEmail1", testPassword1, testSalt1);
		loginDetailsTest2 = new LoginDetails(456, "testUser2", "testEmail2", testPassword2, testSalt2);
	}
	
	@Test
	public void testPersistLoginDetails()
	{
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		testArrayLoginDetails = loginDetailsManager.getAllLoginDetails();
		assertEquals(testArrayLoginDetails.size(), 1);
	}
	
	@Test 
	public void testFindByUsername()
	{
		testArrayLoginDetails.clear();
		testArrayLoginDetails.add(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		assertEquals(loginDetailsManager.findByUsername("testUser1"), testArrayLoginDetails.get(0));
	}
	
	@Test 
	public void testFindByUserId()
	{
		testArrayLoginDetails.clear();
		testArrayLoginDetails.add(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		assertEquals(loginDetailsManager.findByUserId(123), testArrayLoginDetails.get(0));
	}
	
	@Test 
	public void testFindByEmail()
	{
		testArrayLoginDetails.clear();
		testArrayLoginDetails.add(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		assertEquals(loginDetailsManager.findByEmail("testEmail1"), testArrayLoginDetails.get(0));
	}
	
	@Test
	public void testCheckPassword()
	{
		testArrayLoginDetails.clear();
		testArrayLoginDetails.add(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		assertEquals(123,loginDetailsManager.checkPassword("testUser1", "testPassword"));
	}
	
	@Test
	void testUpdateLoginDetails()
	{
		testArrayLoginDetails.clear();
		testArrayLoginDetails.add(loginDetailsTest2);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		loginDetailsManager.updateLoginDetails(loginDetailsTest2);
		assertEquals(loginDetailsManager.getAllLoginDetails(), testArrayLoginDetails);
	}
	
	@Test
	void testRemoveLoginDetails()
	{
		testArrayLoginDetails.add(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest1);
		loginDetailsManager.persistLoginDetails(loginDetailsTest2);
		loginDetailsManager.deleteLoginDetails(loginDetailsTest2);
		assertEquals(loginDetailsManager.getAllLoginDetails(), testArrayLoginDetails);
	}	
	
}
