package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

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
	
	@ManagedProperty(value="#{catalogController}")
	CatalogController catalogController;
	
	List<Product> searchResults;
	String name;
	
	public String headerSearch() {
		name = searchDetails.getSearchEntry();
			if (name.isEmpty() == false) {
			
			System.out.println(name);
			List<Product> searchResults = productManager.findProductsByName(name);
			this.searchResults = searchResults;
			
			}
		return "searchresults.xhtml";
	}

	public List<Product> getSearchResults() {
		
		return searchResults;
	}
	
	/**
	 * @param searchDetails the searchDetails to set
	 */
	public void setSearchDetails(SearchDetails searchDetails) {
		this.searchDetails = searchDetails;
	}

	/**
	 * @param catalogController the catalogController to set
	 */
	public void setCatalogController(CatalogController catalogController) {
		this.catalogController = catalogController;
	}
	
	
	
	
}
