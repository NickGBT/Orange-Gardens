package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.util.StoreFrontProducts;

/**
 * 
 * @author JustinMabbutt
 *
 */

public class StoreFrontController {
	@Inject
	private StoreFrontProducts storeFrontProducts;
	private String pageNav;

	public String productClick(int row, int column) {
		switch (row) {
		case 1:
			switch (column) {
			case 1:
				pageNav = "products/" + storeFrontProducts.getNewProducts().get(0).getProductId();
				break;
			case 2:
				pageNav = "products/" + storeFrontProducts.getNewProducts().get(1).getProductId();
				break;
			case 3:
				pageNav = "products/" + storeFrontProducts.getNewProducts().get(2).getProductId();
				break;
			case 4:
				pageNav = "products/" + storeFrontProducts.getNewProducts().get(3).getProductId();
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (column) {
			case 1:
				pageNav = "products/" + storeFrontProducts.getSpecialOffers().get(0).getProductId();
				break;
			case 2:
				pageNav = "products/" + storeFrontProducts.getSpecialOffers().get(1).getProductId();
				break;
			case 3:
				pageNav = "products/" + storeFrontProducts.getSpecialOffers().get(2).getProductId();
				break;
			case 4:
				pageNav = "products/" + storeFrontProducts.getSpecialOffers().get(3).getProductId();
				break;
			default:
				break;
			}
		case 3:
			switch (column) {
			case 1:
				pageNav = "products/" + storeFrontProducts.getCatalogueExclusives().get(0).getProductId();
				break;
			case 2:
				pageNav = "products/" + storeFrontProducts.getCatalogueExclusives().get(1).getProductId();
				break;
			case 3:
				pageNav = "products/" + storeFrontProducts.getCatalogueExclusives().get(2).getProductId();
				break;
			case 4:
				pageNav = "products/" + storeFrontProducts.getCatalogueExclusives().get(3).getProductId();
				break;
			default:
				break;
			}
		}
		return pageNav;
	}
}