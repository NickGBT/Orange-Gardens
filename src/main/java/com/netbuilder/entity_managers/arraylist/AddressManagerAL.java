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

	public Address findByPostcode(String postcode) 
	{
		for(Address a: addresses)
		{
			if(a.getPostcode() == postcode)
			{
				return a;
			}
		}
		return null;
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
		return null;
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
