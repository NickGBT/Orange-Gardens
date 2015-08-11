package com.netbuilder.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.util.OrderDetails;
import com.netbuilder.util.UserId;

/**
 * 
 * @author jtaylor
 *
 */

@ManagedBean(name = "wishlistController")
@RequestScoped
public class WishlistController 
{
	@Inject
	private UserId userId;
	@Inject
	private OrderLineManager orderLineManager;
	@Inject
	private ProductManager pm;
	@Inject
	private LoginDetailsManager ldm;
	@Inject
	private OrderLineManager olm;
	@Inject
	private OrderManager om;

	private String productId;
	private LoginDetails loginDet;
	private Product foundProduct;
	private OrderLine orderLine;

	private List<OrderLine> wishlist;

	public List<OrderLine> getWishlist() 
	{
		wishlist = orderLineManager.getWishlistOrderLines(userId.getUsername());
		return wishlist;
	}

	public void setWishlist(List<OrderLine> wishlist) {
		this.wishlist = wishlist;
	}
	

	public void removeFromWishlist() 
	{
		productId = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("productId");

		foundProduct = pm.findByProductId(Integer.parseInt(productId));

		loginDet = ldm.findByUsername(userId.getUsername());

		if (om.findBasketByUsername(OrderStatus.wishlist, userId.getUsername()) != null) 
		{
			if (olm.findByProductInWishlist(foundProduct.getProductId()) != null) 
			{
				orderLine = olm.findByProductId(foundProduct.getProductId());
				olm.removeProductLine(orderLine);
			} 
			else 
			{
				System.out.println("WishlistController::Line80:: Wishlist does not contain said item.");
			}
		} 
		else 
		{
			System.out.println("WishlistController::Line85:: Cannot find user wishlist.");
		}
	}


}
