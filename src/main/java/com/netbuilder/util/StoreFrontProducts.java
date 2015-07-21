package com.netbuilder.util;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;

/**
 * 
 * @author JustinMabbutt
 *
 */

@Named
@RequestScoped
public class StoreFrontProducts
{
	private ProductManagerAL productManager;
	
	private ArrayList<Product> newProducts;
	private ArrayList<Product> specialOffers;
	private ArrayList<Product> catalogueExclusives;
	private ArrayList<Product> allProducts;
	
	public StoreFrontProducts()
	{
		newProducts = new ArrayList<Product>();
		specialOffers = new ArrayList<Product>();
		catalogueExclusives = new ArrayList<Product>();
		allProducts = new ArrayList<Product>();
	}
	
	public ArrayList<Product> getNewProducts()
	{
		allProducts = productManager.getAll();
		for(int i = 0; i < 4; i++)
		{
			newProducts.add(allProducts.get(allProducts.size() - i));
		}
		return newProducts;
	}

	public ArrayList<Product> getSpecialOffers()
	{
		return specialOffers;
	}

	public ArrayList<Product> getCatalogueExclusives()
	{
		return catalogueExclusives;
	}

	public ArrayList<Product> getAllProducts() 
	{
		allProducts = productManager.getAll();
		return allProducts;
	}
}