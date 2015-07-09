package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.Address;
import com.netbuilder.entity_managers.interfaces.AddressManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class AddressManagerAL implements AddressManager
{
	private ArrayList<Address> addresses = new ArrayList<Address>();
	
	public void persistAddress(Address address)
	{
		addresses.add(address);
	}

	public void persistAddresses(ArrayList<Address> addresses) 
	{
		addresses.addAll(addresses);
	}

	public ArrayList<Address> findByPostcode(String postcode) 
	{
		ArrayList<Address> results = new ArrayList<Address>();
		for(Address a: addresses)
		{
			if(a.getPostcode().contains(postcode))
			{
				results.add(a);
			}
		}
		return results;
	}

	public Address findByLabel(String label)
	{
		for(Address a: addresses)
		{
			if(a.getAddressLabel() == label)
			{
				return a;
			}
		}
		return null;
	}

	public Address findByCustomerID(int customerID)
	{
		for(Address a: addresses)
		{
			if(a.getCustomer().getCustomerID() == customerID)
			{
				return a;
			}
		}
		return null;
	}

	public ArrayList<Address> getAddresses()
	{
		ArrayList<Address> results = new ArrayList<Address>();
		results.addAll(addresses);
		return results;
	}

	public void updateAddress(Address address)
	{
		for(Address a: addresses)
		{
			if(a.getAddressLabel() == address.getAddressLabel())
			{
				addresses.set(addresses.indexOf(a), address);
			}
		}
	}

	public void removeAddress(Address address)
	{
		for(Address a: addresses)
		{
			if(a.getAddressLabel() == address.getAddressLabel())
			{
				addresses.remove(addresses.indexOf(a));
			}
		}
	}
}
