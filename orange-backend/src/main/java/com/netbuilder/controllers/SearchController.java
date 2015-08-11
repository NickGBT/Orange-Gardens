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
	
	private List<Product> searchResults;
	private String name;
	private String catSelection;
	
	public String headerSearch() {
		System.out.println(catSelection);
		name = searchDetails.getSearchEntry();
		if (name.isEmpty() == false || catSelection.equals("All")) {
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

	/**
	 * @return the catSelection
	 */
	public String getCatSelection() {
		return catSelection;
	}

	/**
	 * @param catSelection the catSelection to set
	 */
	public void setCatSelection(String catSelection) {
		this.catSelection = catSelection;
	}
	
	
	
	
}
