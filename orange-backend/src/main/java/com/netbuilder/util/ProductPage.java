package com.netbuilder.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.ProductManager;

@Path(value = "productpage")
public class ProductPage {
	private ProductManager pM;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id")
	public Product read(@PathParam("id") int id){
		Product product;
		product = pM.findByProductId(id);
		return product;
	}

}
