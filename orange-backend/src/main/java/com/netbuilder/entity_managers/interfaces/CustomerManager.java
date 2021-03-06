package com.netbuilder.entity_managers.interfaces;

import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;

/**
 * 
 * @author JustinMabbutt
 *
 */
@RequestScoped
public interface CustomerManager {
	// CREATE
	public void persistCustomer(Customer customer);

	public void persistCustomer(List<Customer> customers);

	// READ
	public List<Customer> findByFName(String fName);

	public List<Customer> findByLName(String lName);

	public Customer findByUser(LoginDetails customer);

	public Customer findByUsername(String username);
	
	public List<Customer> getCustomers();

	// UPDATE
	public void updateCustomer(Customer customer);

	// DELETE
	public void removeCustomer(Customer customer);
}