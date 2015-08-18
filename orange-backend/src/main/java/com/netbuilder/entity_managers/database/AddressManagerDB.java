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

import com.netbuilder.entities.Address;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.validation.AddressValidator;

/**
 * 
 * @author JustinMabbutt
 *
 */
@Default
@Stateless
public class AddressManagerDB implements AddressManager
{
	@Inject
	private PersistenceManager pm;
	
	private AddressValidator addressValidator;

	public void persistAddress(Address address) 
	{
		if(addressValidator.validateAddress(address))
		{
			EntityManager em = pm.createEntityManager();
			em.getTransaction().begin();
			em.persist(address);
			em.getTransaction().commit();
			pm.closeEntityManager(em);
		}
		else
		{
			//do something (maybe)
		}
	}

	public void persistAddresses(List<Address> addresses) 
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Address c : addresses) 
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public List<Address> findByPostcode(String postcode)
	{
		List<Address> addresses = new ArrayList<Address>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery(Address.FIND_BY_POSTCODE, Address.class);
		tq.setParameter("postcode", postcode);
		try 
		{
			addresses = (ArrayList<Address>) tq.getResultList();
		} 
		catch (NoResultException nre)
		{
			nre.printStackTrace();
			return null;
		}
		pm.closeEntityManager(em);
		return addresses;
	}

	public Address findByAddressLabel(String addressLabel) 
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery(Address.FIND_BY_ADDRESS_LABEL, Address.class);
		tq.setParameter("addressLabel", addressLabel);
		pm.closeEntityManager(em);
		try 
		{
			return tq.getSingleResult();
		}
		catch (NoResultException nre) 
		{
			nre.printStackTrace();
			return null;
		}
	}

	public Address findByUserId(int userId) 
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery(Address.FIND_BY_USER_ID, Address.class);
		tq.setParameter("customer", userId);
		pm.closeEntityManager(em);
		try 
		{
			return tq.getSingleResult();
		} 
		catch (NoResultException nre) 
		{
			nre.printStackTrace();
			return null;
		}
	}

	public List<Address> getAddresses() 
	{
		EntityManager em = pm.createEntityManager();
		List<Address> addresses = (ArrayList<Address>) em.createNamedQuery(Address.GET_ALL, Address.class).getResultList();
		pm.closeEntityManager(em);
		return addresses;
	}

	public void updateAddress(Address address)
	{
		if (address == null) 
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(address);
		pm.closeEntityManager(em);
	}

	public void removeAddress(Address address)
	{
		if (address == null) 
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(address);
		pm.closeEntityManager(em);
	}
}
