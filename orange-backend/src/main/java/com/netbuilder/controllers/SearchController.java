package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.ProductCategory;
import com.netbuilder.util.ProductDetails;
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
	private ProductManager productManager;
	
	@Inject
	private ProductDetails prDet;

	private List<Product> searchResults;
	
	@ManagedProperty(value="#{searchDetails}")
	private SearchDetails searchDetails;
	
	@ManagedProperty(value="#{catalogController}")
	private CatalogController catalogController;
	
	private String name;
	private String catSelection;
	private ProductCategory category;

	private static final Logger logger = LogManager.getLogger();

	private Product pr;

	private String productId;

	public String setProductPage() {

		System.out.println("Set product Page Being Called");
		productId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId");
		System.out.println(productId);
		logger.info("Product Id: " + productId);
		prDet.setId(Integer.parseInt(productId));

		return "productpage.xhtml";

	}
	
	public String headerSearch() {
		System.out.println(catSelection);
		logger.info("Catalogue Selection: " + catSelection);
		name = searchDetails.getSearchEntry();
		
		if (!catSelection.equals("All")){
			category = ProductCategory.valueOf(catSelection);
		}
		if (name.isEmpty() == true && catSelection.equals("All")) {	
			return "webstorefront.xhtml";
			}
		
		if (name.isEmpty() && (!catSelection.equals("All"))){
			System.out.println("Category: " + category);
			logger.info("Category: " + category);
			List<Product> searchResults = productManager.findByCategory(category);
			this.searchResults = searchResults;
			
			return "searchresults.xhtml";
		} 
		
		if(catSelection.equals("All")){
			List<Product> searchResults = productManager.findProductsByName(name);
			this.searchResults = searchResults;
			
			return "searchresults.xhtml";
		} else { 
			System.out.println(name);
			logger.info("Name: " + name);
			ArrayList<Product> searchResults = (ArrayList<Product>) productManager.findProductsByName(name);
			System.out.println(searchResults);
			
			this.searchResults = productManager.findProductsByNameAndCat(category, searchResults);
			
			return "searchresults.xhtml";
		}
		
	}
	
	public void printSomething() {
		System.out.println("Hello");
	}

	public List<Product> getSearchResults() {
		//System.out.println(searchResults.get(0).getProductId());
		//System.out.println(searchResults.get(1).getProductId());
		//System.out.println(searchResults.get(2).getProductId());
		//System.out.println(searchResults.get(3).getProductId());
		return this.searchResults;
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
