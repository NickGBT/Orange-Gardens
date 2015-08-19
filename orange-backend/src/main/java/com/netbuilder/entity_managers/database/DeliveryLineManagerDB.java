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

import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entity_managers.interfaces.DeliveryLineManager;
import com.netbuilder.persistence_manager.PersistenceManager;
import com.netbuilder.validation.DeliveryLineValidator;

/**
 * 
 * @author llew
 *
 */
@Default
@Stateless
public class DeliveryLineManagerDB implements DeliveryLineManager {

	@Inject
	private PersistenceManager pm;
	
	private DeliveryLineValidator deliveryLineValidator;

	public void persistDeliveryLine(DeliveryLine deliveryLine) {
		//if(deliveryLineValidator.validateDeliveryLine(deliveryLine))
		//{
			EntityManager em = pm.createEntityManager();
			em.getTransaction().begin();
			em.persist(deliveryLine);
			em.getTransaction().commit();
			pm.closeEntityManager(em);
		//}
		//else
		//{
			//do something (maybe)
		//}
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
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByProductId", DeliveryLine.class);
		tq.setParameter("product_id", productId);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}

	public DeliveryLine findByDeliveryId(int deliveryId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryId", DeliveryLine.class);
		tq.setParameter("delivery_id", deliveryId);
		pm.closeEntityManager(em);
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
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryId", DeliveryLine.class);
		tq.setParameter("quantity", quantity);
		try {
			delLine = (ArrayList<DeliveryLine>) tq.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		pm.closeEntityManager(em);
		return delLine;
	}

	public List<DeliveryLine> getDeliveryLine() {
		EntityManager em = pm.createEntityManager();
		List<DeliveryLine> delLine = (ArrayList<DeliveryLine>) em.createNamedQuery(DeliveryLine.GET_ALL, DeliveryLine.class).getResultList();
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