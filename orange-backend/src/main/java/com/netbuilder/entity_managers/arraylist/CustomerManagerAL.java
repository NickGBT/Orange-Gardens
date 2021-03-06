package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.interfaces.CustomerManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Alternative
@Singleton
public class CustomerManagerAL implements CustomerManager {
	ArrayList<Customer> customers = new ArrayList<Customer>();

	public void persistCustomer(Customer customer) {
		customers.add(customer);
	}

	public void persistCustomer(List<Customer> passedCustomers) {
		customers.addAll(passedCustomers);
	}

	public List<Customer> findByFName(String fName) {
		List<Customer> results = new ArrayList<Customer>();
		for (Customer c : customers) {
			if (c.getfName().contains(fName)) {
				results.add(c);
			}
		}
		if (results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	public List<Customer> findByLName(String lName) {
		List<Customer> results = new ArrayList<Customer>();
		for (Customer c : customers) {
			if (c.getlName().contains(lName)) {
				results.add(c);
			}
		}
		if (results.isEmpty()) {
			return null;
		} else {
			return results;
		}
	}

	public Customer findByUsername(String username) {
		for (Customer c : customers) {
			if (c.getCustomer().getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer findByUser(LoginDetails customer) {
		for (Customer c : customers) {
			if (c.getCustomer().getUserId() == customer.getUserId()) {
				return c;
			}
		}
		return null;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void updateCustomer(Customer customer) {
		for (Customer c : customers) {
			if (c.getCustomer().getUserId() == customer.getCustomer()
					.getUserId()) {
				customers.set(customers.indexOf(c), customer);
			}
		}
	}

	public void removeCustomer(Customer customer) {
		for (Customer c : customers) {
			if (c.getCustomer().getUserId() == customer.getCustomer()
					.getUserId()) {
				customers.remove(customers.indexOf(c));
			}
		}
	}

}