package com.netbuilder.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.util.OrderDetails;
import com.netbuilder.util.UserId;

/**
 * 
 * @author ngilbert & jtaylor
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

	private List<OrderLine> wishlist;

	public List<OrderLine> getWishlist() 
	{
		wishlist = orderLineManager.getWishlistOrderLines(userId.getUsername());
		return wishlist;
	}

	public void setWishlist(List<OrderLine> wishlist) {
		this.wishlist = wishlist;
	}


}
