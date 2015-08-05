package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ManagedProperty;
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

	@ManagedProperty(value = "#{testData}")
	private TestData testData;

	private Product product_genID; 
	private Product product;
	private Product product2 ;
	private Product product3;
	
	private ArrayList<Product> products = new ArrayList<Product>();

	public ProductManagerAL() {
		
		product_genID = new Product(1, "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);	
		
		product = new Product("img/iomg", "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);	
		
		product2 = new Product("img/iomg", "testproduct2", 29.25, 53, 90, 15, 15.50, "test Product 2", ProductCategory.Gnome);	
		
		product3 = new Product("img/iomg", "testproduct3", 76.25, 80, 45, 18, 19.50, "test Product 3", ProductCategory.Furniture);	
		
		products.add(product_genID);
		products.add(product2);
		products.add(product);
		products.add(product3);

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
