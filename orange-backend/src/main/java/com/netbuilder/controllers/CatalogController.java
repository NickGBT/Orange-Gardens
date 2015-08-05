package com.netbuilder.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.ProductManagerAL;
import com.netbuilder.entity_managers.interfaces.ProductManager;

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
	ProductManagerAL productManager;
	
	/*public ArrayList<Product> getRelevantProducts(ProductCategory productCategory)
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
	}	*/
	
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String displayCatalogPage(Model model)
	{
		System.out.println("/catalouge");
		ArrayList<Product> productsInCatalog = new ArrayList<Product>();
		productManager.populateProducts();
		productsInCatalog = (ArrayList<Product>) productManager.getAll();
		model.addAttribute("items", productsInCatalog);
		System.out.println(productsInCatalog.size());
		return "items";
	}
}

