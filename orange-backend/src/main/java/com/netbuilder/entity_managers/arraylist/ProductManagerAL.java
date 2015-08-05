package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.ProductCategory;
import com.netbuilder.util.TestData;

/**
 * 
 * @author Alexander Neil
 *
 */
@Alternative
@Singleton
public class ProductManagerAL implements ProductManager {

	@Inject
	private TestData testData;

	private ArrayList<Product> products = new ArrayList<Product>() {
		/**
				 * 
				 */
		private static final long serialVersionUID = 1L;

		{
			/*System.out.println(testData);
			products.add(testData.getProduct());
			products.add(testData.getProduct2());
			products.add(testData.getProduct3());*/
		}
	};

	public ProductManagerAL() {
		System.out.println(testData);
		products.add(testData.getProduct());
		products.add(testData.getProduct2());
		products.add(testData.getProduct3());
	}

	public void persistProduct(Product product) {
		products.add(product);
	}

	public void persistProducts(List<Product> products) {
		this.products.addAll(products);
	}

	public Product findByProductId(int productId) {

		for (Product p : products) {
			if (p.getProductId() == productId)
				return p;
		}
		return null;
	}

	public List<Product> getAll() {
		return products;
	}

	public List<Product> findProductsByName(String name) {
		List<Product> results = new ArrayList<Product>();

		for (Product p : products) {
			if (p.getProductName().contains(name))
				results.add(p);
		}
		return results;
	}

	public List<Product> findProductsByPriceBetween(double lowPrice,
			double highPrice) {
		List<Product> results = new ArrayList<Product>();

		for (Product p : products) {
			if ((lowPrice < p.getProductPrice())
					&& (p.getProductPrice() < highPrice))
				results.add(p);
		}
		return results;
	}

	public List<Product> findByCategory(ProductCategory category) {

		List<Product> results = new ArrayList<Product>();

		for (Product p : products) {
			if (category == p.getCategory())
				results.add(p);
		}

		return results;
	}

	public void updateProduct(Product product) {
		for (Product p : products) {
			if (p.getProductId() == product.getProductId()) {
				products.set(products.indexOf(p), product);
				return;
			}
		}
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}
}
