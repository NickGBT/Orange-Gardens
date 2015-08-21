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

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.ProductCategory;
import com.netbuilder.persistence_manager.PersistenceManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Default
@Stateless
public class ProductManagerDB implements ProductManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistProduct(Product product) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void persistProducts(List<Product> products) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for (Product p : products) {
			em.persist(p);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public List<Product> getAll() {

		List<Product> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.GET_ALL, Product.class);
		System.out.println(tq);
		try {
			results = new ArrayList<Product>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		pm.closeEntityManager(em);
		return results;
	}

	public Product findByProductId(int productId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_ID, Product.class);
		tq.setParameter("id", productId);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		finally {
			pm.closeEntityManager(em);
		}
	}

	public List<Product> findProductsByName(String name) {

		List<Product> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_NAME, Product.class);
		tq.setParameter("name", name);
		try {
			results = new ArrayList<Product>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		pm.closeEntityManager(em);
		return results;

	}

	public List<Product> findProductsByPriceBetween(double lowPrice,
			double highPrice) {

		List<Product> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_PRICE, Product.class);
		tq.setParameter("lPrice", lowPrice);
		tq.setParameter("hPrice", highPrice);
		try {
			results = new ArrayList<Product>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		pm.closeEntityManager(em);
		return results;
	}

	public List<Product> findByCategory(ProductCategory category) {

		List<Product> results = null;

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_CATEGORY, Product.class);
		tq.setParameter("category", category);
		try {
			results = new ArrayList<Product>(tq.getResultList());
		} catch (NoResultException nre) {

		}
		pm.closeEntityManager(em);
		return results;
	}

	public void updateProduct(Product product) {

		if (product == null) {
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(product);
		pm.closeEntityManager(em);
	}

	public void removeProduct(Product product) {

		if (product == null) {
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(product);
		pm.closeEntityManager(em);
	}

	@Override
	public List<Product> findProductsByNameAndCat(ProductCategory category, ArrayList<Product> products) {
		
		List<Product> categorySearchResult = new ArrayList<Product>(); 
		
		for (Product r : products) { 
			
			if (r.getCategory() == category ) {
				
				categorySearchResult.add(r);
			}
		}
		System.out.println("Found results : " + categorySearchResult);
		return categorySearchResult;
	}
}