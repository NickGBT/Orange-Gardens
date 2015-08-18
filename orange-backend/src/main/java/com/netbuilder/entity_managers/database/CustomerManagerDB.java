package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entity_managers.interfaces.CustomerManager;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.validation.CustomerValidator;

/**
 * 
 * @author JustinMabbutt
 *
 */
@Default
@Stateless
public class CustomerManagerDB implements CustomerManager
{
	@Inject
	private PersistenceManager pm;
	
	private CustomerValidator customerValidator;

	public void persistCustomer(Customer customer) 
	{
		if(customerValidator.validateCustomer(customer))
		{
			EntityManager em = pm.createEntityManager();
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			pm.closeEntityManager(em);
		}
		else
		{
			//do something (maybe)
		}
	}

	public void persistCustomer(List<Customer> customers) 
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Customer c : customers)
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public List<Customer> findByFName(String fName) 
	{
		List<Customer> customers = new ArrayList<Customer>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery(Customer.FIND_BY_FIRST_NAME, Customer.class);
		tq.setParameter("fName", fName);
		try 
		{
			customers = (ArrayList<Customer>) tq.getResultList();
		} 
		catch (NoResultException nre)
		{
			nre.printStackTrace();
			return null;
		}
		pm.closeEntityManager(em);
		return customers;
	}

	public List<Customer> findByLName(String lName)
	{
		List<Customer> customers = new ArrayList<Customer>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery(Customer.FIND_BY_LAST_NAME, Customer.class);
		tq.setParameter("lName", lName);
		try
		{
			customers = (ArrayList<Customer>) tq.getResultList();
		} 
		catch (NoResultException nre) 
		{
			return null;
		}
		pm.closeEntityManager(em);
		return customers;
	}

	public Customer findByUser(LoginDetails customer) 
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery(Customer.FIND_BY_USER_ID, Customer.class);
		tq.setParameter("customer", customer);
		try 
		{
			return tq.getSingleResult();
		} 
		catch (NoResultException nre) 
		{
			return null;
		}
		finally{
			pm.closeEntityManager(em);
		}
	}

	public List<Customer> getCustomers()
	{
		EntityManager em = pm.createEntityManager();
		List<Customer> customers = (ArrayList<Customer>) em.createNamedQuery(Customer.GET_ALL, Customer.class).getResultList();
		pm.closeEntityManager(em);
		return customers;
	}

	public void updateCustomer(Customer customer) 
	{
		if (customer == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(customer);
		pm.closeEntityManager(em);
	}

	public void removeCustomer(Customer customer)
	{
		if (customer == null) 
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(customer);
		pm.closeEntityManager(em);
	}

	@Override
	public Customer findByUsername(String username) 
	{
		//Unneccessary once ids are in place
		return null;
	}

}
