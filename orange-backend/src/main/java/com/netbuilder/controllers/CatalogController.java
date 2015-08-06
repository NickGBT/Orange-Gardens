package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
//import com.netbuilder.entity_managers.interfaces.ProductManager;
//import com.netbuilder.enums.ProductCategory;
import com.netbuilder.entity_managers.interfaces.ProductManager;

/**
 * 
 * @author ngilbert
 *
 **/

@ManagedBean (name = "catalogController")
@RequestScoped
public class CatalogController 
{	
	@Inject
	ProductManager productManager;
	
	private ArrayList<Product> productsInCatalog = new ArrayList<Product>();
	
	/*public ArrayList<Product> getProductsInCatalog() 
	{
		productManager.populateProducts();
		productsInCatalog = (ArrayList<Product>) productManager.getAll();
		return productsInCatalog;
	}*/

	public void setProductsInCatalog(ArrayList<Product> productsInCatalog) 
	{
		this.productsInCatalog = productsInCatalog;
	}
	
	public List<Product> getProdsToDisplay() {
		return productManager.getAll();
	}

	/*public ArrayList<Product> getProductsInCatalog(ProductCategory productCategory)
	{
		if (productCategory == null)
		{
			productManager.populateProducts();
			productsInCatalog = (ArrayList<Product>) productManager.getAll();
		}
		else
		{
			productsInCatalog = (ArrayList<Product>) productManager.findByCategory(productCategory);
		}
		
		return productsInCatalog;	
	}*/
	
	/*
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String displayCatalogPage(Model model)
	{
		System.out.println("/catalouge");
		ArrayList<Product> productsInCatalog = new ArrayList<Product>();
		//productManager.populateProducts();
		productsInCatalog = (ArrayList<Product>) productManager.getAll();
		model.addAttribute("items", productsInCatalog);
		System.out.println(productsInCatalog.size());
		return "items";
	}*/
}

