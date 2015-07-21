package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.util.StoreFrontProducts;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StoreFrontController 
{
	@Inject
	private StoreFrontProducts storeFrontProducts;
	@Inject
	private ProductManagerAL productManager;
	
	public String productClick()
	{
		
		return "ProductPage/";
	}
}