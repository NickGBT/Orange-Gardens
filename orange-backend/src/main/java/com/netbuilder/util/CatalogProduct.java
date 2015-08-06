package com.netbuilder.util;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path(value = "catalog")
public class CatalogProduct{
	
	private String title = "Catalog";
	
	@GET
	@Produces("text/plain")
	@Path("{id}")
	public String getProduct(@PathParam("id") String id, @DefaultValue("0") @QueryParam("page")int page){
		String returnString = id + ": " + title + ", page " + page;
		return returnString;
	}	
	
	@POST
	@Consumes("text/plain")
	public void postClichedMessage(String message){
		title = message;
	}
	

}
