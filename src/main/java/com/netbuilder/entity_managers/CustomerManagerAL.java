package com.netbuilder.entity_managers;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;

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
			if(c.getUsername() == username)
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
			if(c.getEmailAddress() == email)
			{
				return c;
			}
		}
		return null;
	}

	public Customer findByFName(String fName)
	{
		for(Customer c: customers)
		{
			if(c.getfName() == fName)
			{
				return c;
			}
		}
		return null;
	}

	public Customer findByLName(String lName)
	{
		for(Customer c: customers)
		{
			if(c.getlName() == lName)
			{
				return c;
			}
		}
		return null;
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
		ArrayList<Customer> results = new ArrayList<Customer>();
		
		return null;
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
