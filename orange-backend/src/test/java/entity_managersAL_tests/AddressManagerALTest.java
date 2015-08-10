package entity_managersAL_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.arraylist.AddressManagerAL;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class AddressManagerALTest {
	private List<Address> testArrayAddress, testArrayAddress2;
	private Address testAddress, testAddress2;
	private LoginDetails testCustomer, testCustomer2;
	private AddressManagerAL addressManager;
	byte[] password = { 1, 2, 3 };
	byte[] salt = { 1, 2, 3 };

	@Before
	public void setUp() throws Exception {
		addressManager = new AddressManagerAL();
		testArrayAddress = new ArrayList<Address>();
		testArrayAddress2 = new ArrayList<Address>();
		testAddress = new Address(testCustomer, "house", "absolutely",
				"fantastic", "pull", "bounce", "cheese", "LEY76R", false);
		testAddress2 = new Address(testCustomer2, "shed", "banter", "hell",
				"earth", "junit", "java", "ABCDEF", false);
		testCustomer = new LoginDetails("fooUser", "testEmail1", password, salt);
		testCustomer2 = new LoginDetails("fooUser2", "testEmail2", password,
				salt);
	}

	@Test
	public void testPersistAddress() {
		addressManager.persistAddress(testAddress);
		testArrayAddress = addressManager.getAddresses();
		assertEquals(testArrayAddress.size(), 1);
	}

	@Test
	public void testPersistAddresses() {
		testArrayAddress2.add(testAddress);
		testArrayAddress2.add(testAddress2);
		addressManager.persistAddresses(testArrayAddress2);
		testArrayAddress = addressManager.getAddresses();
		assertEquals(testArrayAddress.size(), 2);
	}

	@Test
	public void testFindByPostcode() {
		testArrayAddress.add(testAddress);
		addressManager.persistAddress(testAddress);
		assertEquals(addressManager.findByPostcode("LEY76R"), testArrayAddress);
	}

	@Test
	public void testFindByLabel() {
		testArrayAddress.add(testAddress);
		addressManager.persistAddress(testAddress);
		assertEquals(addressManager.findByAddressLabel("house"),
				testArrayAddress);
	}

	/*
	 * @Test public void testFindByCustomerID() {
	 * assertEquals(testAddress.getCustomer().getCustomerID(), 1); }
	 */

	@Test
	public void testGetAddresses() {
		testArrayAddress.add(testAddress);
		testArrayAddress.add(testAddress2);
		addressManager.persistAddresses(testArrayAddress);
		testArrayAddress2 = addressManager.getAddresses();
		assertEquals(addressManager.getAddresses(), testArrayAddress2);
	}

	@Test
	public void updateAddress() {
		testArrayAddress.add(testAddress);
		addressManager.persistAddresses(testArrayAddress);
		addressManager.updateAddress(testAddress);
		assertEquals(addressManager.getAddresses(), testArrayAddress);
	}

	@Test
	public void removeAddress() {
		testArrayAddress.add(testAddress);
		testArrayAddress.add(testAddress2);
		testArrayAddress2.add(testAddress);
		addressManager.persistAddresses(testArrayAddress);
		addressManager.removeAddress(testAddress2);
		assertEquals(addressManager.getAddresses(), testArrayAddress2);
	}
}