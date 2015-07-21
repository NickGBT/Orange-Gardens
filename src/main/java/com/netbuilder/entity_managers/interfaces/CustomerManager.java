package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;

/**
 * 
 * @author JustinMabbutt
 *
 */

public interface CustomerManager
{
	//CREATE
	public void persistCustomer(Customer customer);
	public void persistCustomer(ArrayList<Customer> customers);
	
	//READ
	public Customer findByUsername(String username);
	public Customer findByEmail(String email);
	public ArrayList<Customer> findByFName(String fName);
	public ArrayList<Customer> findByLName(String lName);
	public Customer findByCustomerID(int customerID);
	public ArrayList<Customer> getCustomers();
	public long checkUsernameDetails(String username, String password);
	public long checkEmailDetails(String email, String password);
	
	//UPDATE
	public void updateCustomer(Customer customer);
	
	//DELETE
	public void removeCustomer(Customer customer);
}