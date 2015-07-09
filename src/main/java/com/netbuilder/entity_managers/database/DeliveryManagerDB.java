package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Delivery;
import com.netbuilder.entity_managers.interfaces.DeliveryManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author ngilbert
 *
 */
@Default
public class DeliveryManagerDB implements DeliveryManager {
	@Inject
	private PersistenceManager pm;

	//////// CRUD FUNCTIONS ////////
	public void persistDelivery(Delivery delivery) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(delivery);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}
	public void persistDeliveries(ArrayList<Delivery> deliveries) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Delivery delivery : deliveries)
		{
			em.persist(delivery);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}
	////////// READ ///////////////
	public ArrayList<Delivery> findByDatePlaced(String datePlaced) {
		// TODO Auto-generated method stub
		return null;
	}
	public Delivery findByDeliveryID(int deliveryID) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Delivery> getDeliveries() {
		// TODO Auto-generated method stub
		return null;
	}
	/////////// UPDATE ////////////
	public void updateDelivery(Delivery delivery) {
		// TODO Auto-generated method stub

	}
	/////////// DELETE ////////////
	public void removeDelivery(Delivery delivery) {
		// TODO Auto-generated method stub

	}

}
