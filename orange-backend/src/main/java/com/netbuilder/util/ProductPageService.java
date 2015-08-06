package com.netbuilder.util;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path ("/catalog")
public class ProductPageService {

		@Path("clickedproduct")
		@POST
		public int productId(@FormParam("productid") String pid){
			
			int productId = Integer.parseInt(pid);
			return productId; 
					
		}
}
