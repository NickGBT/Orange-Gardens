package com.netbuilder.entity_managers.database;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.orange_gardens.PersistenceManager;

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

	public void persistProducts(ArrayList<Product> products) {

		EntityManager em = pm.createEntityManager();
		em.getTransaction().begin();
		for(Product p: products){
			em.persist(p);
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public Product findByProductId(int productId) {

		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_ID, Product.class);
		pm.closeEntityManager(em);
		tq.setParameter("id", productId);
		try{
			return tq.getSingleResult();
		}
		catch(NoResultException nre){
			return null;
		}
	}

	public ArrayList<Product> findProductsByName(String name) {
		
		ArrayList<Product> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_NAME, Product.class);
		pm.closeEntityManager(em);
		tq.setParameter("name", name);
		try{
			results = new ArrayList<Product>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
		
	}

	public ArrayList<Product> findProductsByPriceBetween(double lowPrice, double highPrice) {
		
		ArrayList<Product> results = null;
		
		EntityManager em = pm.createEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(Product.FIND_BY_PRODUCT_PRICE, Product.class);
		pm.closeEntityManager(em);
		tq.setParameter("lPrice", lowPrice);
		tq.setParameter("hPrice", highPrice);
		try{
			results = new ArrayList<Product>(tq.getResultList());
		}
		catch(NoResultException nre){
			
		}
		return results;
	}

	public void updateProduct(Product product) {

		if(product == null){
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.merge(product);
		pm.closeEntityManager(em);
	}

	public void removeProduct(Product product) {
		
		if(product == null){
			throw new ValidationException("Null product passed!");
		}
		EntityManager em = pm.createEntityManager();
		em.remove(product);
		pm.closeEntityManager(em);
	}

}
