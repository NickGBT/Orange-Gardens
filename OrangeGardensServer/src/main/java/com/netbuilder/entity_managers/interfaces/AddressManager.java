package com.netbuilder.entity_managers.interfaces;

import java.util.List;

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
	public void persistAddresses(List<Address> addresses);

	// READ
	public List<Address> findByPostcode(String postcode);
	public Address findByAddressLabel(String addressLabel);
	public Address findByUserId(int userId);
	public List<Address> getAddresses();

	// UPDATE
	public void updateAddress(Address address);

	// DELETE
	public void removeAddress(Address address);
}