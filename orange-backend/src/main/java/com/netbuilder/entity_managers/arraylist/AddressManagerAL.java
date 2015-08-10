package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.Address;
import com.netbuilder.entity_managers.interfaces.AddressManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
@Singleton
public class AddressManagerAL implements AddressManager {
	private ArrayList<Address> addresses = new ArrayList<Address>();

	public void persistAddress(Address address) {
		addresses.add(address);
	}

	public void persistAddresses(List<Address> addresses) {
		addresses.addAll(addresses);
	}

	public List<Address> findByPostcode(String postcode) {
		List<Address> results = new ArrayList<Address>();
		for (Address a : addresses) {
			if (a.getPostcode().contains(postcode)) {
				results.add(a);
			}
		}
		if (results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	public Address findByAddressLabel(String addressLabel) {
		for (Address a : addresses) {
			if (a.getAddressLabel().equals(addressLabel)) {
				return a;
			}
		}
		return null;
	}

	public Address findByUserId(int userId) {
		for (Address a : addresses) {
			if (a.getCustomer().getUserId() == userId) {
				return a;
			}
		}
		return null;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void updateAddress(Address address) {
		for (Address a : addresses) {
			if (a.getAddressLabel().equals(address.getAddressLabel())) {
				addresses.set(addresses.indexOf(a), address);
			}
		}
	}

	public void removeAddress(Address address) {
		for (Address a : addresses) {
			if (a.getAddressLabel().equals(address.getAddressLabel())) {
				addresses.remove(addresses.indexOf(a));
			}
		}
	}
}
