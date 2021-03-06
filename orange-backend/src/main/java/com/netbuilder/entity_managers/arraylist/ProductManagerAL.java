package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.ProductCategory;
import com.netbuilder.util.DummyAL;

/**
 * 
 * @author Alexander Neil
 *
 */

@Alternative
@Singleton
public class ProductManagerAL implements ProductManager {
	@Inject
	private DummyAL dummyAL;

	public ProductManagerAL() {

	}

	public void persistProduct(Product product) {
		dummyAL.allProducts.add(product);
	}

	public void persistProducts(List<Product> products) {
		this.dummyAL.allProducts.addAll(products);
	}

	public Product findByProductId(int productId) {
		for (Product p : dummyAL.allProducts) {
			if (p.getProductId() == productId)
				return p;
		}
		return null;
	}

	public List<Product> getAll() {
		dummyAL.addProducts();
		return dummyAL.getAllProducts();

	}

	/**
	 * @author mwatson
	 */
	public List<Product> findProductsByName(String name) {
		List<Product> results = new ArrayList<Product>();

		for (Product p : dummyAL.allProducts) {
			Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(p.getProductName());
			
			
			if (matcher.find()) {
				results.add(p);
			}
		}
		
		return results;
	}

	public List<Product> findProductsByPriceBetween(double lowPrice,
			double highPrice) {
		List<Product> results = new ArrayList<Product>();

		for (Product p : dummyAL.allProducts) {
			if ((lowPrice < p.getProductPrice())
					&& (p.getProductPrice() < highPrice))
				results.add(p);
		}
		return results;
	}

	public List<Product> findProductsByNameAndCat(ProductCategory category, ArrayList<Product> products){
		
		List<Product> categorySearchResult = new ArrayList<Product>(); 
		
		for (Product r : products) { 
			
			if (r.getCategory() == category ) {
				
				categorySearchResult.add(r);
			}
		}
		System.out.println("Found results : " + categorySearchResult);
		return categorySearchResult;
	}
	
	public List<Product> findByCategory(ProductCategory category) {

		List<Product> results = new ArrayList<Product>();

		for (Product p : dummyAL.allProducts) {
			if (category == p.getCategory())
				results.add(p);
		}

		return results;
	}

	public void updateProduct(Product product) {
		for (Product p : dummyAL.allProducts) {
			if (p.getProductId() == product.getProductId()) {
				dummyAL.allProducts
						.set(dummyAL.allProducts.indexOf(p), product);
			}
		}
	}

	public void removeProduct(Product product) {
		dummyAL.allProducts.remove(product);
	}
}
