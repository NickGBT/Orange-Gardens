package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Address;

<<<<<<< HEAD
public interface AddressManager {
	// CREATE
=======
/**
 * 
 * @author JustinMabbutt
 *
 */

public interface AddressManager 
{
	//CREATE
>>>>>>> d61cb044c97864607127408e4e3e344c471d6a63
	public void persistAddress(Address address);

	public void persistAddresses(ArrayList<Address> addresses);

	// READ
	public Address findByPostcode(String postcode);
<<<<<<< HEAD

=======
	public Address findByLabel(String label);
	public Address findByCustomerID(int customerID);
>>>>>>> d61cb044c97864607127408e4e3e344c471d6a63
	public ArrayList<Address> getAddresses();

	// UPDATE
	public void updateAddress(Address address);

	// DELETE
	public void removeAddress(Address address);
}