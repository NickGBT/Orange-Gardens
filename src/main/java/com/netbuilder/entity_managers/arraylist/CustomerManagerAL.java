package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Customer;
import com.netbuilder.entity_managers.interfaces.CustomerManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
public class CustomerManagerAL implements CustomerManager
{
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public void persistCustomer(Customer customer)
	{
		customers.add(customer);
	}
 
	public void persistCustomer(ArrayList<Customer> customers)
	{
		customers.addAll(customers);
	}

	public Customer findByUsername(String username) 
	{
		for(Customer c: customers)
		{
			if(c.getUsername().equals(username))
			{
				return c;
			}
		}
		return null;
	}

	public Customer findByEmail(String email)
	{
		for(Customer c: customers)
		{
			if(c.getEmailAddress().equals(email))
			{
				return c;
			}
		}
		return null;
	}

	public ArrayList<Customer> findByFName(String fName)
	{
		ArrayList<Customer> results = new ArrayList<Customer>();
		for(Customer c: customers)
		{
			if(c.getfName().contains(fName))
			{
				results.add(c);
			}
		}
		if(results.isEmpty())
		{
			return null;
		}
		else
		{
			return results;
		}	
	}

	public ArrayList<Customer> findByLName(String lName)
	{
		ArrayList<Customer> results = new ArrayList<Customer>();
		for(Customer c: customers)
		{
			if(c.getlName().contains(lName))
			{
				results.add(c);
			}
		}
		if(results.isEmpty())
		{
			return null;
		}
		else
		{
			return results;
		}	
	}

	public Customer findByCustomerID(int customerID)
	{
		for(Customer c: customers)
		{
			if(c.getCustomerID() == customerID)
			{
				return c;
			}
		}
		return null;
	}

	public ArrayList<Customer> getCustomers()
	{
		return customers;
	}

	public void updateCustomer(Customer customer) 
	{
		for(Customer c: customers)
		{
			if(c.getCustomerID() == customer.getCustomerID())
			{
				customers.set(customers.indexOf(c), customer);
			}
		}
	}

	public void removeCustomer(Customer customer) 
	{
		for(Customer c: customers)
		{
			if(c.getCustomerID() == customer.getCustomerID())
			{
				customers.remove(customers.indexOf(c));
			}
		}
	}
}