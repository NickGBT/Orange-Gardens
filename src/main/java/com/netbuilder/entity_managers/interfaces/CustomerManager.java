package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Delivery;

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
	public Customer findByFName(String fName);
	public Customer findByLName(String lName);
	public Customer findByCustomerID(int customerID);
	public ArrayList<Customer> getCustomers();
	
	//UPDATE
	public void updateCustomer(Customer customer);
	
	//DELETE
	public void removeCustomer(Customer customer);
}