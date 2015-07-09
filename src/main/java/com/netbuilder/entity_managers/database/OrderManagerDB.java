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

import com.netbuilder.entities.Order;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.orange_gardens.PersistenceManager;


/**
 * 
 * @author mwatson
 *
 */

@NamedQueries({@NamedQuery(name = "FindByOrderId", query = "SELECT a FROM order WHERE a.order_id = :order_id"),
			   @NamedQuery(name = "FindByStatus" , query = "SELECT a FROM order WHERE a.status = :status"),
			   @NamedQuery(name = "FindByDateDispatched" , query = "SELECT a FROM order WHERE a.date_dispatched = :date_dispatched"),
			   @NamedQuery(name = "FindByDatePlaced" , query = "SELECT a FROM order WHERE a.date_placed = :date_placed"),
			   @NamedQuery(name = "FindByDateDelivered" , query = "SELECT a FROM order WHERE a.date_delivered = :date_delivered"),
			   @NamedQuery(name = "FindByTwoDatesOrderPlaced" , query = "SELECT a FROM order WHERE a.date_placed BETWEEN :fDate AND sDate"),
			   @NamedQuery(name = "FindByTwoDatesOrderDispatched" , query = "SELECT a FROM order WHERE a.date_dispatched BETWEEN :fDate AND sDate"),
			   @NamedQuery(name = "FindByTwoDatesOrderDelivered" , query = "SELECT a FROM order WHERE a.date_delivered BETWEEN :fDate AND sDate"),
			   @NamedQuery(name = "FindByCustomerId", query = "SELECT a FROM order WHERE a.customer_id = :customer_id"),
			   @NamedQuery(name = "FindByEmployeeId", query = "SELECT a FROM order WHERE a.employee_id = :employee_id"),
})

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
		TypedQuery<Order> tq = em.createNamedQuery("FindByOrderId", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("order_id", OrderID);
		
		try{ 
			return tq.getSingleResult();
		} catch(NoResultException nre) {
		return null;
		}
	}

	public ArrayList<Order> findByStatus(OrderStatus status) {
		
		ArrayList<Order> orders = new ArrayList<Order>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByStatus", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("status", status);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByDatePlaced(String datePlaced) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByDatePlaced", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("date_placed", datePlaced);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByDateDispatched(String dateDispatched) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByDateDispatched", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("date_dispatched", dateDispatched);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByDateDelivered(String dateDelivered) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByDateDelivered", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("date_delivered", dateDelivered);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByTwoDatesOrderPlaced(String firstDate, String secondDate) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByTwoDatesOrderPlaced", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByTwoDatesOrderDispatched(String firstDate, String secondDate) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByTwoDatesOrderDispatched", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByTwoDatesOrderDelivered(String firstDate, String secondDate) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByTwoDatesOrderDelivered", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("fdate", firstDate);
		tq.setParameter("sdate", secondDate);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByCustomerId(int customerId) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByCustomerId", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("customer_id", customerId);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public ArrayList<Order> findByEmployeeId(int employeeId) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Order> tq = em.createNamedQuery("FindByEmployeeId", Order.class);
		pm.closeEntityManager(em);
		tq.setParameter("employee_id", employeeId);
		
		try{ 
			orders = (ArrayList<Order>)tq.getResultList();			
		} catch(NoResultException nre) {
		return null;
		}
		
		return orders;
	}

	public void updateOrder(Order order) {
		if(order == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(order);
		pm.closeEntityManager(em);
		
	}

}
