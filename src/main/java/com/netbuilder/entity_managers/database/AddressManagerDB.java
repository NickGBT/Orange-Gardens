package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Address;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@NamedQueries ({@NamedQuery(name = "FindByPostcode", query = "SELECT a FROM address WHERE a.postcode = :postcode"), 
				@NamedQuery(name = "FindByLabel", query = "SELECT a FROM address WHERE a.address_label = :address_label"),
				@NamedQuery(name = "FindByCustomerID", query = "SELECT a FROM address WHERE a.customer_id = :customer_id")})

@Default
public class AddressManagerDB implements AddressManager 
{
	private PersistenceManager pm;
	
	public void persistAddress(Address address)
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistAddresses(ArrayList<Address> addresses)
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(Address c : addresses)
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public ArrayList<Address> findByPostcode(String postcode)
	{
		ArrayList<Address> addresses = new ArrayList<Address>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByPostcode", Address.class);
		pm.closeEntityManager(em);
		tq.setParameter("critical_stock", postcode);
		try
		{
			addresses = (ArrayList<Address>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return addresses;
		}
	}

	public Address findByLabel(String label) 
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByLabel", Address.class);
		pm.closeEntityManager(em);
		tq.setParameter("address_label", label);
		try
		{
			return tq.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	public Address findByCustomerID(int customerID)
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByCustomerID", Address.class);
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

	public ArrayList<Address> getAddresses()
	{
		EntityManager em = pm.createEntityManager();
		ArrayList<Address> addresses = (ArrayList<Address>)em.createQuery("SELECT a FROM address a", Address.class).getResultList();
		pm.closeEntityManager(em);
		return addresses;
	}

	public void updateAddress(Address address) 
	{
		if(address == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(address);
		pm.closeEntityManager(em);
	}

	public void removeAddress(Address address)
	{
		if(address == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(address);
		pm.closeEntityManager(em);
	}
}
