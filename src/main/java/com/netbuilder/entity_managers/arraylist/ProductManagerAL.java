package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.orange_gardens.PersistenceManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Stateless
public class ProductManagerAL implements ProductManager {

	private List<Product> products = new ArrayList<Product>();
	
	public void persistProduct(Product product) {
		products.add(product);

	}

	public void persistProducts(ArrayList<Product> products) {
		this.products.addAll(products);
	}

	public Product findByProductId(int productId) {
		
		for(Product p: products){
			if(p.getProductId() == productId) return p;
		}
		return null;
	}

	public ArrayList<Product> findProductsByName(String name) {
		ArrayList<Product> results = new ArrayList<Product>();
		
		for(Product p: products){
			if(p.getProductName().contains(name)) results.add(p);
		}
		return results;
	}

	public ArrayList<Product> findProductsByPriceBetween(double lowPrice, double highPrice) {
		ArrayList<Product> results = new ArrayList<Product>();
		
		for(Product p: products){
			if((lowPrice < p.getProductPrice())&&(p.getProductPrice() < highPrice)) results.add(p);
		}
		return results;
	}

	public void updateProduct(Product product) {
		for(Product p: products){
			if(p.getProductId() == product.getProductId()){
				products.set(products.indexOf(p), product);
				return;
			}
		}
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

}
