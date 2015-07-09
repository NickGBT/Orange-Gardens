package com.netbuilder.entity_managers.database;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Stock;
import com.netbuilder.entity_managers.interfaces.StockManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

@NamedQueries ({@NamedQuery(name = "FindByCriticalThreshold", query = "SELECT a FROM stock WHERE a.critical_stock = :critical_stock"), 
				@NamedQuery(name = "FindByRequiredStock", query = "SELECT a FROM customer WHERE a.required_stock = :required_stock"),
				@NamedQuery(name = "FindByStockLevel", query = "SELECT a FROM customer WHERE a.stock_level = :stock_level"), 
				@NamedQuery(name = "FindByMaxStock", query = "SELECT a FROM customer WHERE a.maximum_stock = :maximum_stock"), 
				@NamedQuery(name = "FindByStockAvailable", query = "SELECT a FROM customer WHERE a.stock_available = :stock_available"),
				@NamedQuery(name = "FindByProductID", query = "SELECT a FROM stock WHERE a.product_id = :product_id"),})

@Default
public class StockManagerDB implements StockManager
{
	@Inject
	private PersistenceManager pm;
	
	public void persistStock(Stock stock)
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(stock);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistStock(ArrayList<Stock> stock)
	{
		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(Stock c : stock)
		{
			em.persist(c);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public ArrayList<Stock> findByCriticalThreshold(int criticalThreshold) 
	{
		ArrayList<Stock> stock = new ArrayList<Stock>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByCriticalThreshold", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("critical_stock", criticalThreshold);
		try
		{
			stock = (ArrayList<Stock>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return stock;
		}
	}

	public ArrayList<Stock> findByRequiredStock(int requiredStock)
	{
		ArrayList<Stock> stock = new ArrayList<Stock>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByRequiredStock", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("required_stock", requiredStock);
		try
		{
			stock = (ArrayList<Stock>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return stock;
		}
	}

	public ArrayList<Stock> findByStockLevel(int stockLevel)
	{
		ArrayList<Stock> stock = new ArrayList<Stock>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByStockLevel", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("stock_level", stockLevel);
		try
		{
			stock = (ArrayList<Stock>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return stock;
		}
	}

	public ArrayList<Stock> findByStockAvailable(int stockAvailable) 
	{
		ArrayList<Stock> stock = new ArrayList<Stock>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByStockAvailable", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("stock_available", stockAvailable);
		try
		{
			stock = (ArrayList<Stock>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return stock;
		}
	}

	public ArrayList<Stock> findByMaximumStock(int maxStock) 
	{
		ArrayList<Stock> stock = new ArrayList<Stock>();
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByMaxStock", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("maximum_stock", maxStock);
		try
		{
			stock = (ArrayList<Stock>)tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
		finally
		{
			return stock;
		}
	}

	public Stock findByProductID(int productID)
	{
		EntityManager em = pm.createEntityManager();
		TypedQuery<Stock> tq = em.createNamedQuery("FindByEmail", Stock.class);
		pm.closeEntityManager(em);
		tq.setParameter("product_id", productID);
		try
		{
			return tq.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	public ArrayList<Stock> getStock()
	{
		EntityManager em = pm.createEntityManager();
		ArrayList<Stock> stock = (ArrayList<Stock>)em.createQuery("SELECT a FROM stock a", Stock.class).getResultList();
		pm.closeEntityManager(em);
		return stock;
	}

	public void updateStock(Stock stock) 
	{
		if(stock == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(stock);
		pm.closeEntityManager(em);
	}

	public void removeStock(Stock stock)
	{
		if(stock == null)
		{
			throw new ValidationException("null value passed");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(stock);
		pm.closeEntityManager(em);
	}
}
