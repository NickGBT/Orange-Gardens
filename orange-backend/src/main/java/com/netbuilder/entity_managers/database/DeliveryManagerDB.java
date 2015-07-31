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

import com.netbuilder.entities.Delivery;
import com.netbuilder.entity_managers.interfaces.DeliveryManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author ngilbert
 *
 */

@NamedQueries({
		@NamedQuery(name = "FindByDatePlaced", query = "SELECT a FROM delivery WHERE a.datePlaced = :datePlaced"),
		@NamedQuery(name = "FindByDeliveryId", query = "SELECT a FROM delivery WHERE a.delivery_id = :delivery_id"), })
@Default
@Stateless
public class DeliveryManagerDB implements DeliveryManager {
	@Inject
	private PersistenceManager pm;

	// ////// CRUD FUNCTIONS ////////
	// ////////// CREATE /////////////
	public void persistDelivery(Delivery delivery) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(delivery);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistDeliveries(List<Delivery> deliveries) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Delivery delivery : deliveries) {
			em.persist(delivery);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	// //////// READ ///////////////
	@SuppressWarnings("finally")
	public List<Delivery> findByDatePlaced(String datePlaced) {
		List<Delivery> deliveries = new ArrayList<Delivery>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Delivery> tq = em.createNamedQuery("FindByDatePlaced",
				Delivery.class);
		pm.closeEntityManager(em);
		tq.setParameter("dateplaced", datePlaced);
		try {
			deliveries = (ArrayList<Delivery>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		} finally {
			return deliveries;
		}
	}

	public Delivery findByDeliveryId(int deliveryId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<Delivery> tq = em.createNamedQuery("FindByDeliveryId",
				Delivery.class);
		pm.closeEntityManager(em);
		tq.setParameter("delivery_id", deliveryId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Delivery> getDeliveries() {
		EntityManager em = pm.createEntityManager();
		List<Delivery> deliveries = (ArrayList<Delivery>) em.createQuery(
				"SELECT a FROM delivery a", Delivery.class).getResultList();
		pm.closeEntityManager(em);
		return deliveries;
	}

	// ///////// UPDATE ////////////
	public void updateDelivery(Delivery delivery) {
		if (delivery == null)
			throw new ValidationException("null value passed ");
		EntityManager em = pm.createEntityManager();
		em.merge(delivery);
		pm.closeEntityManager(em);

	}

	// ///////// DELETE ////////////
	public void removeDelivery(Delivery delivery) {
		if (delivery == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.createEntityManager();
		em.remove(delivery);
		pm.closeEntityManager(em);

	}

}
