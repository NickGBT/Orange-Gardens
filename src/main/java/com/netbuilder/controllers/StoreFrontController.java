package com.netbuilder.controllers;

import javax.inject.Inject;

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
	
	public StoreFrontController()
	{
		
	}
	
	public String productClick()
	{
		
		return "ProductPage/";
	}
}