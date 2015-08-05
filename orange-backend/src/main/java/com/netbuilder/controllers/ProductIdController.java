package com.netbuilder.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import com.netbuilder.util.CatalogProduct;

@Controller
public class ProductIdController {

	@RequestMapping("/catalog")
	@ResponseBody
	public HttpEntity<CatalogProduct>products(@RequestParam(value = "id", required = true) String id)
	{
		
		CatalogProduct catalogP = new CatalogProduct(id);
		catalogP.add(linkTo(methodOn(ProductIdController.class).products(id)).withSelfRel());
		return new ResponseEntity<CatalogProduct>(catalogP , HttpStatus.OK);
		
	}
	
}
