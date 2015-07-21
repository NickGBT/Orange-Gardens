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
		
		return newProducts;
	}

	public void setNewProducts(ArrayList<Product> newProducts)
	{
		this.newProducts = newProducts;
	}

	public void setSpecialOffers(ArrayList<Product> specialOffers) 
	{
		this.specialOffers = specialOffers;
	}

	public void setCatalogueExclusives(ArrayList<Product> catalogueExclusives)
	{
		this.catalogueExclusives = catalogueExclusives;
	}

	public void setAllProducts(ArrayList<Product> allProducts)
	{
		this.allProducts = allProducts;
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
		return allProducts;
	}
}