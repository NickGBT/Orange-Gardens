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
	public ArrayList<Customer> findByFName(String fName);
	public ArrayList<Customer> findByLName(String lName);
	public Customer findByUserId(int userId);
	public ArrayList<Customer> getCustomers();
	
	//UPDATE
	public void updateCustomer(Customer customer);
	
	//DELETE
	public void removeCustomer(Customer customer);
}