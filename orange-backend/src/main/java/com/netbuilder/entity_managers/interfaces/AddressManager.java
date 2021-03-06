package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author JustinMabbutt
 *
 */
@RequestScoped
public interface AddressManager {
	// CREATE
	public void persistAddress(Address address);

	public void persistAddresses(List<Address> addresses);

	// READ
	public List<Address> findByPostcode(String postcode);

	public Address findByAddressLabel(String addressLabel);

	public Address findByUserId(LoginDetails customer);

	public List<Address> getAddresses();

	// UPDATE
	public void updateAddress(Address address);

	// DELETE
	public void removeAddress(Address address);
}