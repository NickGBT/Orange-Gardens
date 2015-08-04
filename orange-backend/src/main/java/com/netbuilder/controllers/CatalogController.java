package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author ngilbert
 *
 **/

//@Named
//@RequestScoped
@Controller
public class CatalogController 
{	
	//@Inject
	public ArrayList<Product> productsInCatalog = new ArrayList<Product>();	
	ProductManagerAL productManager;
	
	public ArrayList<Product> getRelevantProducts(ProductCategory productCategory)
	{
		if (productCategory == null)
		{
			productsInCatalog = (ArrayList<Product>) productManager.getAll();
		}
		else
		{
			productsInCatalog = (ArrayList<Product>) productManager.findByCategory(productCategory);
		}
		
		return productsInCatalog;	
	}	
	
	@RequestMapping(value = "/ShowItems.htm")
	public String showItems(ModelMap model)
	{
		model.addAttribute("Items", productsInCatalog);
		return "ShowItems";
	}
}

