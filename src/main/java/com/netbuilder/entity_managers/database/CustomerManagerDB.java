package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Customer;
import com.netbuilder.orange_gardens.PersistenceManager;
import com.netbuilder.entity_managers.interfaces.CustomerManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@NamedQueries ({@NamedQuery(name = "FindByUsername", query = "SELECT a FROM customer WHERE a.username = :username"), 
				@NamedQuery(name = "FindByEmail", query = "SELECT a FROM customer WHERE a.email_address = :email_address"),
				@NamedQuery(name = "FindByfName", query = "SELECT a FROM customer WHERE a.fname = :fname"), 
				@NamedQuery(name = "FindBylName", query = "SELECT a FROM customer WHERE a.lname = :lname"),
				@NamedQuery(name = "FindByCustomerID", query = "SELECT a FROM customer WHERE a.customer_id = :customer_id"),})

@Default
@Stateless
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
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("FindByUsername", Customer.class);
		pm.closeEntityManager(em);
		tq.setParameter("username", username);
		try
		{
			return tq.getSingleResult();
		}
		catch(NoResultException nre)
		{
			nre.printStackTrace();
			return null;
		}
	}

	public Customer findByEmail(String email) 
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("FindByEmail", Customer.class);
		pm.closeEntityManager(em);
		tq.setParameter("email_address", email);
		try
		{
			return tq.getSingleResult();
		}
		catch(NoResultException nre)
		{
			nre.printStackTrace();
			return null;
		}
	}

	public ArrayList<Customer> findByFName(String fName)
	{
		ArrayList<Customer> customers = new ArrayList<Customer>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("FindByfName", Customer.class);
		pm.closeEntityManager(em);
		tq.setParameter("fname", fName);
		try
		{
			customers = (ArrayList<Customer>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			nre.printStackTrace();
			return null;
		}
		return customers;
	}

	public ArrayList<Customer> findByLName(String lName)
	{
		ArrayList<Customer> customers = new ArrayList<Customer>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("FindBylName", Customer.class);
		pm.closeEntityManager(em);
		tq.setParameter("lname", lName);
		try
		{
			customers = (ArrayList<Customer>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		return customers;
	}

	public Customer findByCustomerID(int customerID)
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("FindByCustomerID", Customer.class);
		pm.closeEntityManager(em);
		tq.setParameter("customer_id", customerID);
		try
		{
			return tq.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	public ArrayList<Customer> getCustomers() 
	{
		EntityManager em = pm.createEntityManager();
		ArrayList<Customer> customers = (ArrayList<Customer>)em.createQuery("SELECT a FROM customer a", Customer.class).getResultList();
		pm.closeEntityManager(em);
		return customers;
	}

	public void updateCustomer(Customer customer)
	{
		if(customer == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(customer);
		pm.closeEntityManager(em);
	}

	public void removeCustomer(Customer customer) 
	{
		if(customer == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(customer);
		pm.closeEntityManager(em);
	}

	public long checkUsernameDetails(String username, String password)
	{
		return 0;
	}

	public long checkEmailDetails(String email, String password) 
	{
		return 0;
	}
}
