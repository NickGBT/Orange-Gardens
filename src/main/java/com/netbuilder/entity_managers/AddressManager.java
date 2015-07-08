package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Address;

public interface AddressManager {
	// CREATE
	public void persistAddress(Address address);

	public void persistAddresses(ArrayList<Address> addresses);

	// READ
	public Address findByPostcode(String postcode);

	public ArrayList<Address> getAddresses();

	// UPDATE
	public void updateAddress(Address address);

	// DELETE
	public void removeAddress(Address address);
}