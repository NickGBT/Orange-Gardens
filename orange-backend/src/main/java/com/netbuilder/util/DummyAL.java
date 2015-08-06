package com.netbuilder.util;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.netbuilder.entities.Product;
import com.netbuilder.enums.ProductCategory;

@Singleton
public class DummyAL 
{
	
	Product product = new Product("resources/img/gardenLight.jpg", "Garden Light", 25.25, 10, 10, 11, 10.50, "This will light up your life.", ProductCategory.Accessory);	
	
	Product product2 = new Product("resources/img/coolGnome.jpg", "Cool Gnome", 29.25, 53, 90, 15, 15.50, "This gnome is cool.", ProductCategory.Gnome);	
	
	Product product3 = new Product("resources/img/gardenSeat.jpg", "Relaxation Chair", 76.25, 80, 45, 18, 19.50, "Relax.", ProductCategory.Furniture);
	
	Product product4 = new Product("resources/img/swagShed.jpg", "Swag Shed", 1976.25, 80, 45, 18, 19.50, "Store your swag inside.", ProductCategory.Building);
	
	public List<Product> allProducts = new ArrayList<Product>();
				
	public List<Product> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(ArrayList<Product> allProducts) {
		this.allProducts = allProducts;
	}
			
	public void addProducts()
	{
		allProducts.clear();
		allProducts.add(product);
		allProducts.add(product2);
		allProducts.add(product3);
		allProducts.add(product4);
	}
}
