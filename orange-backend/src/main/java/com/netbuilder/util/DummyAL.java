package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.netbuilder.entities.Product;
import com.netbuilder.enums.ProductCategory;
import com.netbuilder.util.TestData;

@Singleton
public class DummyAL 
{
	Product product = new Product("img/iomg", "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);	
	
	Product product2 = new Product("img/iomg", "testproduct2", 29.25, 53, 90, 15, 15.50, "test Product 2", ProductCategory.Gnome);	
	
	Product product3 = new Product("img/iomg", "testproduct3", 76.25, 80, 45, 18, 19.50, "test Product 3", ProductCategory.Furniture);
	
	public ArrayList<Product> allProducts = new ArrayList<Product>();
			

	public ArrayList<Product> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(ArrayList<Product> allProducts) {
		this.allProducts = allProducts;
	}
			
	public void addProducts()
	{
		allProducts.add(product);
		allProducts.add(product2);
		allProducts.add(product3);
	}
}
