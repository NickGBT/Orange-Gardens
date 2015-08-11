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

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author llew
 *
 */

@NamedQueries({
		@NamedQuery(name = "FindByProductID", query = "SELECT o FROM order_line WHERE o.product_id = :product_id"),
		@NamedQuery(name = "FindByOrderID", query = "SELECT o FROM order_line WHERE o.order_id = :order_id"),
		@NamedQuery(name = "FindByQuantity", query = "SELECT o FROM order_line WHERE o.quantity = :quantity") })
@Default
@Stateless
public class OrderLineManagerDB implements OrderLineManager {

	@Inject
	private PersistenceManager pm;

	public void persistOrderLine(OrderLine orderLine) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(orderLine);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistOrderLine(List<OrderLine> orderLine) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (OrderLine c : orderLine) {
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public OrderLine findByProductId(int productID) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery("FindByProductID",
				OrderLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("product_id", productID);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderLine> findByOrderId(int orderId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery("FindByProductID",
				OrderLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("order_id", orderId);
		try {
			return tq.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderLine> findByQuantity(int quantity) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery("FindByDeliveryID",
				OrderLine.class);
		pm.closeEntityManager(em);
		tq.setParameter("quantity", quantity);
		try {
			orderLine = (ArrayList<OrderLine>) tq.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return orderLine;
	}

	public List<OrderLine> getOrderLine() {
		EntityManager em = pm.createEntityManager();
		List<OrderLine> orderLine = (ArrayList<OrderLine>) em.createQuery(
				"select d from order_line d", OrderLine.class).getResultList();
		pm.closeEntityManager(em);
		return orderLine;
	}

	public void updateProductLine(OrderLine orderLine) {
		if (orderLine == null)
			throw new ValidationException("null value passed ");
		EntityManager em = pm.createEntityManager();
		em.merge(orderLine);
		pm.closeEntityManager(em);

	}

	public void removeProductLine(OrderLine orderLine) {
		if (orderLine == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.createEntityManager();
		em.remove(orderLine);
		pm.closeEntityManager(em);

	}

	public void updateOrderLine(OrderLine orderLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderLine findByProductInBasket(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderLine findByProductInWishlist(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLine> getBasketOrderLines(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLine> getWishlistOrderLines(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
