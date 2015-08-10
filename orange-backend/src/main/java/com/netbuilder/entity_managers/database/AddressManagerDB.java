package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Address;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@NamedQueries({
		@NamedQuery(name = "FindByPostcode", query = "SELECT a FROM address WHERE a.postcode = :postcode"),
		@NamedQuery(name = "FindByAddressLabel", query = "SELECT a FROM address WHERE a.address_label = :address_label"),
		@NamedQuery(name = "FindByUserId", query = "SELECT a FROM address WHERE a.user_id = :user_id") })
@Default
@Stateless
public class AddressManagerDB implements AddressManager {
	@Inject
	private PersistenceManager pm;

	public void persistAddress(Address address) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistAddresses(List<Address> addresses) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Address c : addresses) {
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public List<Address> findByPostcode(String postcode) {
		List<Address> addresses = new ArrayList<Address>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByPostcode",
				Address.class);
		pm.closeEntityManager(em);
		tq.setParameter("postcode", postcode);
		try {
			addresses = (ArrayList<Address>) tq.getResultList();
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		}
		return addresses;
	}

	public Address findByAddressLabel(String addressLabel) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByAddressLabel",
				Address.class);
		pm.closeEntityManager(em);
		tq.setParameter("address_label", addressLabel);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		}
	}

	public Address findByUserId(int userId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<Address> tq = em.createNamedQuery("FindByUserId",
				Address.class);
		pm.closeEntityManager(em);
		tq.setParameter("user_id", userId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			nre.printStackTrace();
			return null;
		}
	}

	public List<Address> getAddresses() {
		EntityManager em = pm.createEntityManager();
		List<Address> addresses = (ArrayList<Address>) em.createQuery(
				"SELECT a FROM address a", Address.class).getResultList();
		pm.closeEntityManager(em);
		return addresses;
	}

	public void updateAddress(Address address) {
		if (address == null) {
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(address);
		pm.closeEntityManager(em);
	}

	public void removeAddress(Address address) {
		if (address == null) {
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(address);
		pm.closeEntityManager(em);
	}
}
