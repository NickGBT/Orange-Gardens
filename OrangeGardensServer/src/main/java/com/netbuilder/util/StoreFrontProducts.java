package com.netbuilder.util;

import java.util.List;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StoreFrontProducts
{
	private ProductManager productManager;
	
	private List<Product> newProducts;
	private List<Product> specialOffers;
	private List<Product> catalogueExclusives;
	private List<Product> allProducts;

	public List<Product> getNewProducts()
	{
		allProducts = productManager.getAll();
		for(int i = 0; i < 4; i++)
		{
			newProducts.add(allProducts.get(allProducts.size() - i));
		}
		return newProducts;
	}

	public List<Product> getSpecialOffers()
	{
		allProducts = productManager.getAll();
		for(int i = 0; i < 4; i++)
		{
			specialOffers.add(allProducts.get(i));
		}
		return specialOffers;
	}

	public List<Product> getCatalogueExclusives()
	{
		allProducts = productManager.getAll();
		for(int i = 8; i < 12; i++)
		{
			specialOffers.add(allProducts.get(i));
		}
		return catalogueExclusives;
	}

	public List<Product> getAllProducts() 
	{
		allProducts = productManager.getAll();
		return allProducts;
	}
}