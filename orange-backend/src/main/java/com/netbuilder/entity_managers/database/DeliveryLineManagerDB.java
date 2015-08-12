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

import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entity_managers.interfaces.DeliveryLineManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author llew
 *
 */
@NamedQueries({
		@NamedQuery(name = "FindByProductId", query = "SELECT d FROM delivery_line WHERE d.product_id = :product_id"),
		@NamedQuery(name = "FindByDeliveryId", query = "SELECT d FROM delivery_line WHERE d.delivery_id = :delivery_id"),
		@NamedQuery(name = "FindByQuantity", query = "SELECT d FROM delivery_line WHERE d.quantity = :quantity") })
@Default
@Stateless
public class DeliveryLineManagerDB implements DeliveryLineManager {

	@Inject
	private PersistenceManager pm;

	public void persistDeliveryLine(DeliveryLine deliveryLine) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(deliveryLine);
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public void persistDeliveryLine(List<DeliveryLine> deliveryLines) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (DeliveryLine c : deliveryLines) {
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public DeliveryLine findByProductId(int productId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByProductId",
				DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("product_id", productId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}

	public DeliveryLine findByDeliveryId(int deliveryId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryId",
				DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("delivery_id", deliveryId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DeliveryLine> findByQuantity(int quantity) {
		List<DeliveryLine> delLine = new ArrayList<DeliveryLine>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryId",
				DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("quantity", quantity);
		try {
			delLine = (ArrayList<DeliveryLine>) tq.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return delLine;
	}

	public List<DeliveryLine> getDeliveryLine() {
		EntityManager em = pm.createEntityManager();
		List<DeliveryLine> delLine = (ArrayList<DeliveryLine>) em.createQuery(
				"select d from delivery_line d", DeliveryLine.class)
				.getResultList();
		pm.closeEntityManager(em);
		return delLine;
	}

	public void updateDeliveryLine(DeliveryLine deliveryLine) {
		if (deliveryLine == null)
			throw new ValidationException("null value passed ");
		EntityManager em = pm.createEntityManager();
		em.merge(deliveryLine);
		pm.closeEntityManager(em);

	}

	public void removeDeliveryLine(DeliveryLine deliveryLine) {
		if (deliveryLine == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.createEntityManager();
		em.remove(deliveryLine);
		pm.closeEntityManager(em);

	}

}
