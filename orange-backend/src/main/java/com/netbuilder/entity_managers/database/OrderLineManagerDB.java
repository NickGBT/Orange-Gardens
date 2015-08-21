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

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author llew
 *
 */
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
		TypedQuery<OrderLine> tq = em.createNamedQuery(OrderLine.FIND_BY_PRODUCT_ID, OrderLine.class);
		tq.setParameter("product", productID);
		try {
			pm.closeEntityManager(em);
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderLine> findByOrderId(int orderId) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery(OrderLine.FIND_BY_ORDER_ID, OrderLine.class);
		tq.setParameter("order", orderId);
		pm.closeEntityManager(em);
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
		TypedQuery<OrderLine> tq = em.createNamedQuery(OrderLine.FIND_BY_QUANTITY, OrderLine.class);
		tq.setParameter("quantity", quantity);
		pm.closeEntityManager(em);
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
		List<OrderLine> orderLine = (ArrayList<OrderLine>) em.createNamedQuery(OrderLine.GET_ALL, OrderLine.class).getResultList();
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
		if (orderLine == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(orderLine);
		pm.closeEntityManager(em);
	}

	@Override
	public OrderLine findByProductInBasket(int productID) {
		/*OrderLine orderLine;
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery(OrderLine.GET_PRODUCT_IN_BASKET, OrderLine.class);
		tq.setParameter("quantity", productID);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}*/
		
		return null;
	}

	@Override
	public OrderLine findByProductInWishlist(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLine> getBasketOrderLines(Order order) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<OrderLine> tq = em.createNamedQuery(OrderLine.FIND_BY_ORDER_ID, OrderLine.class);
		tq.setParameter("order", order);
		try {
			orderLine = (ArrayList<OrderLine>) tq.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		
		pm.closeEntityManager(em);
		return orderLine;
		
	}

	@Override
	public List<OrderLine> getWishlistOrderLines(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderLine> findProductsPlaced(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProductLineFromWishlist(OrderLine orderLine) {
		// TODO Auto-generated method stub
		
	}
}
