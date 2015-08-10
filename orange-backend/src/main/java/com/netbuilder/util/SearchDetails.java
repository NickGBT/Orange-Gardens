package com.netbuilder.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * 
 * @author mwatson
 *
 */

@ManagedBean(name = "searchDetails")
@RequestScoped
public class SearchDetails {

	String searchEntry;

	
	
	public SearchDetails() {
	}

	/**
	 * @return the searchEntry
	 */
	public String getSearchEntry() {
		return searchEntry;
	}

	/**
	 * @param searchEntry the searchEntry to set
	 */
	public void setSearchEntry(String searchEntry) {
		this.searchEntry = searchEntry;
	}
	
	
	
	
}
