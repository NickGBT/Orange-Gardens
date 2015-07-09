package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.entities.Customer;
import com.netbuilder.orange_gardens.PersistenceManager;
import com.netbuilder.entity_managers.interfaces.CustomerManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Default
public class CustomerManagerDB implements CustomerManager
{
	@Inject
	private PersistenceManager pm;
	
	public void persistCustomer(Customer customer)
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistCustomer(ArrayList<Customer> customers) 
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(Customer c : customers)
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public Customer findByUsername(String username) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByEmail(String email) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> findByFName(String fName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> findByLName(String lName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByCustomerID(int customerID)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Customer> getCustomers() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCustomer(Customer customer)
	{
		// TODO Auto-generated method stub

	}

	public void removeCustomer(Customer customer) 
	{
		// TODO Auto-generated method stub

	}

}
