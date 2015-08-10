package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.util.SearchDetails;

/**
 * 
 * @author mwatson
 *
 */

@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController {
	
	@Inject 
	ProductManager productManager;
	
	@ManagedProperty(value="#{searchDetails}")
	SearchDetails searchDetails;
	
	@ManagedProperty(value="#{}")
	CatalogController catalogController;
	
	ArrayList<Product> searchResults;
	String name;
	
	public String headerSearch() { 
		name = searchDetails.getSearchEntry();
		System.out.println(name);
		ArrayList<Product> searchResults = (ArrayList<Product>) productManager.findProductsByName(name);
		System.out.println(searchResults);
		System.out.println(searchResults.get(0).getProductName());
		catalogController.setProductsInCatalog(searchResults);
		this.searchResults = searchResults;
		return "catalog.xhtml";
	}

	/**
	 * @param searchDetails the searchDetails to set
	 */
	public void setSearchDetails(SearchDetails searchDetails) {
		this.searchDetails = searchDetails;
	}
	
	
	
	
}
