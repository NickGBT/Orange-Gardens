package com.netbuilder.util;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path ("/catalog.xtml")
public class ProductPageService {

		@Path("clickedproduct")
		@POST
		public int productId(@FormParam("productid") String pid){
			System.out.println("POST" + pid);
			int productId = Integer.parseInt(pid);
			return productId; 
					
		}
}
