package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entity_managers.interfaces.CustomerManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class CustomerManagerDB implements CustomerManager
{
	public void persistCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void persistCustomer(ArrayList<Customer> customers) {
		// TODO Auto-generated method stub

	}

	public Customer findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> findByFName(String fName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> findByLName(String lName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByCustomerID(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

}
