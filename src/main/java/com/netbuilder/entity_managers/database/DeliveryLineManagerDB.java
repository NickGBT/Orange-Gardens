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

import com.netbuilder.entities.Address;
import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entity_managers.interfaces.DeliveryLineManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author llew
 *
 */
@NamedQueries ({@NamedQuery(name = "FindByProductID", query = "SELECT d FROM delivery_line WHERE d.product_id = :product_id"),
				@NamedQuery(name = "FindByDeliveryID", query = "SELECT d FROM delivery_line WHERE d.delivery_id = :delivery_id"),
				@NamedQuery(name = "FindByQuantity", query = "SELECT d FROM delivery_line WHERE d.quantity = :quantity")})

@Default
@Stateless
public class DeliveryLineManagerDB implements DeliveryLineManager{

	@Inject
	private PersistenceManager pm;
	
	public void persistDeliveryLine(DeliveryLine deliveryLine) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(deliveryLine);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
		
	}

	public void persistDeliveryLine(ArrayList<DeliveryLine> deliveryLines) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(DeliveryLine c : deliveryLines)
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
		
	}

	public DeliveryLine findByProductID(int productID) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByProductID", DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("product_id", productID);
		try{
			return tq.getSingleResult();
		}catch(NoResultException e){
			e.printStackTrace();
			return null;
		}
		
	}

	public DeliveryLine findByDeliveryID(int deliveryID) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryID", DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("delivery_id", deliveryID);
		try{
			return tq.getSingleResult();
		}catch(NoResultException e){
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<DeliveryLine> findByQuantity(int quantity) {
		ArrayList<DeliveryLine> delLine = new ArrayList<DeliveryLine>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<DeliveryLine> tq = em.createNamedQuery("FindByDeliveryID", DeliveryLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("quantity", quantity);
		try{
			delLine =  (ArrayList<DeliveryLine>) tq.getResultList();
		}catch(NoResultException e){
			e.printStackTrace();
			return null;
		}
		return delLine;
	}

	public ArrayList<DeliveryLine> getDeliveryLine() {
		EntityManager em = pm.createEntityManager();
		ArrayList<DeliveryLine> delLine = 
				(ArrayList<DeliveryLine>) em.createQuery("select d from delivery_line d", DeliveryLine.class).getResultList();
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
