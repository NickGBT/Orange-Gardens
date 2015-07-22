package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Stateless
public class ProductManagerAL implements ProductManager {

	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void persistProduct(Product product) {
		products.add(product);

	}

	public void persistProducts(List<Product> products) {
		this.products.addAll(products);
	}

	public Product findByProductId(int productId) {
		
		for(Product p: products){
			if(p.getProductId() == productId) return p;
		}
		return null;
	}

	public List<Product> getAll(){
		return products;
	}
	
	public List<Product> findProductsByName(String name) {
		List<Product> results = new ArrayList<Product>();
		
		for(Product p: products){
			if(p.getProductName().contains(name)) results.add(p);
		}
		return results;
	}

	public List<Product> findProductsByPriceBetween(double lowPrice, double highPrice) {
		List<Product> results = new ArrayList<Product>();
		
		for(Product p: products){
			if((lowPrice < p.getProductPrice())&&(p.getProductPrice() < highPrice)) results.add(p);
		}
		return results;
	}
	
	public List<Product> findNewProducts(){
		List<Product> results = new ArrayList<Product>();
		
		for(int i = 0; i < 4 ; i++){
			results.add(products.get(products.size() - i));
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
