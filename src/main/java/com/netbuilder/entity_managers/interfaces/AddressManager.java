package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.Address;

/**
 * 
 * @author JustinMabbutt
 *
 */

public interface AddressManager 
{
	//CREATE
	public void persistAddress(Address address);
	public void persistAddresses(ArrayList<Address> addresses);

	// READ
	public ArrayList<Address> findByPostcode(String postcode);
	public Address findByAddressLabel(String addressLabel);
	public Address findByUserId(int userId);
	public ArrayList<Address> getAddresses();

	// UPDATE
	public void updateAddress(Address address);

	// DELETE
	public void removeAddress(Address address);
}