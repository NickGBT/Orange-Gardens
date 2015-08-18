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
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author mwatson
 *
 */
@Default
@Stateless
public class OrderManagerDB implements OrderManager {

	@Inject
	private PersistenceManager pm;

	public void persistOrder(Order order) {
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public Order findByOrderID(int OrderID) {
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_ORDER_ID, Order.class);
		tq.setParameter("order_id", OrderID);
		pm.closeEntityManager(em);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Order> findByStatus(OrderStatus status) {

		List<Order> orders = new ArrayList<Order>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_STATUS, Order.class);
		tq.setParameter("status", status);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByDatePlaced(String datePlaced) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_DATE_PLACED, Order.class);
		tq.setParameter("date_placed", datePlaced);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByDateDispatched(String dateDispatched) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_DATE_DISPATCHED, Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("date_dispatched", dateDispatched);

		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByDateDelivered(String dateDelivered) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_DATE_DELIVERED, Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("date_delivered", dateDelivered);

		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByTwoDatesOrderPlaced(String firstDate,
			String secondDate) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_TWO_DATES_PLACED, Order.class);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByTwoDatesOrderDispatched(String firstDate,
			String secondDate) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_TWO_DATES_DISPATCHED, Order.class);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByTwoDatesOrderDelivered(String firstDate,
			String secondDate) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_TWO_DATES_DELIVERED, Order.class);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByCustomerId(int customerId) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_CUSTOMER_ID, Order.class);
		tq.setParameter("customer_id", customerId);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public List<Order> findByEmployeeId(int employeeId) {
		List<Order> orders = new ArrayList<Order>();

		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery(Order.FIND_BY_EMPLOYEE_ID, Order.class);
		tq.setParameter("employee_id", employeeId);
		pm.closeEntityManager(em);
		try {
			orders = (ArrayList<Order>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}

		return orders;
	}

	public void updateOrder(Order order) {
		if (order == null) {
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(order);
		pm.closeEntityManager(em);

	}

	public List<Order> getAllOrders() {
		EntityManager em = pm.createEntityManager();
		List<Order> order = (ArrayList<Order>) em.createQuery(
				"select d from order d", Order.class).getResultList();
		pm.closeEntityManager(em);
		return order;
	}

	@Override
	public int findWishlist(OrderStatus status, int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findBasket(OrderStatus status, int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findBasketByUsername(OrderStatus status, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findPreviousOrders(OrderStatus status, String username) {
		// TODO Auto-generated method stub
		return null;
	}
}