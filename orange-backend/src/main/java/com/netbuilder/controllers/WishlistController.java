package com.netbuilder.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.ProductManager;
import com.netbuilder.enums.OrderStatus;
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
	private Order orderBasket;
	private String emptyWishlist = "";

	private static final Logger logger = LogManager.getLogger();
	
	private List<OrderLine> wishlist;

	public List<OrderLine> getWishlist() 
	{
		
		wishlist = orderLineManager.getWishlistOrderLines(om.findBasketByUserId(
				OrderStatus.wishlist, ldm.findByUserId(userId.getUid())));
		
		if (wishlist.size() < 1)
		{
			emptyWishlist = "There are currently no items in your wishlist.";
		}
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

		loginDet = ldm.findByUserId(userId.getUid());

		if (om.findBasketByUserId(OrderStatus.wishlist, loginDet) != null) 
		{
			if (olm.findByProductInWishlist(foundProduct.getProductId()) != null) 
			{
				orderLine = olm.findByProductInWishlist(foundProduct.getProductId());
				olm.removeProductLineFromWishlist(orderLine);
			} 
			else 
			{
				logger.info("WishlistController::Line80:: Wishlist does not contain said item.");
				System.out.println("WishlistController::Line80:: Wishlist does not contain said item.");
			}
		} 
		else 
		{
			logger.info("WishlistController::Line80:: Wishlist does not contain said item.");
			System.out.println("WishlistController::Line85:: Cannot find user wishlist.");
		}
	}


	public void addToBasketFromWishlist() 
	{
		productId = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("productId");

		foundProduct = pm.findByProductId(Integer.parseInt(productId));

		loginDet = ldm.findByUserId(userId.getUid());

		if (om.findBasketByUserId(OrderStatus.basket, loginDet) != null) 
		{
			//System.out.println("WishlistController::Line103::Found basket");
			if (olm.findByProductInBasket(foundProduct.getProductId()) == null) 
			{
				//System.out.println("WishlistController::Line103::Selected item is not already in basket");
				orderBasket = om.findBasketByUserId(OrderStatus.basket, loginDet);
				orderLine = new OrderLine(orderBasket, foundProduct, 1);
				olm.persistOrderLine(orderLine);
			} 
			orderLine = olm.findByProductInWishlist(foundProduct.getProductId());
			olm.removeProductLineFromWishlist(orderLine);		
		} 
		else 
		{
			//System.out.println("WishlistController::Line115::Current basket not found, creating basket.");
			orderBasket = new Order(loginDet, OrderStatus.basket);
			om.persistOrder(orderBasket);
			orderLine = new OrderLine(orderBasket, foundProduct, 1);
			olm.persistOrderLine(orderLine);	
			orderLine = olm.findByProductInWishlist(foundProduct.getProductId());
			olm.removeProductLineFromWishlist(orderLine);	
		}
	}
	
	public void addAllToBasketFromWishlist() 
	{
		loginDet = ldm.findByUsername(userId.getUsername());
				
		orderBasket = om.findBasketByUserId(OrderStatus.basket, loginDet);
		
		wishlist = orderLineManager.getWishlistOrderLines(om.findBasketByUserId(
				OrderStatus.wishlist, ldm.findByUserId(userId.getUid())));
		
		//System.out.println("WishlistController::Line148::Method Called");
		
		if (wishlist.size() > 0) 
		{
			if (om.findBasketByUserId(OrderStatus.basket, loginDet) != null) 
			{
				for (OrderLine ol : wishlist) 
				{
					if (olm.findByProductInBasket(ol.getProduct().getProductId()) == null) 
					{
						//System.out.println("WishlistController::Line103::Selected item is not already in basket");
						orderLine = new OrderLine(orderBasket, ol.getProduct(),1);
						olm.persistOrderLine(orderLine);
						orderLine = olm.findByProductInWishlist(ol.getProduct().getProductId());
						olm.removeProductLineFromWishlist(orderLine);
					}
					else
					{
						orderLine = olm.findByProductInWishlist(ol.getProduct().getProductId());
						olm.removeProductLineFromWishlist(orderLine);
					}
				}
			}	
			else 
			{
				//System.out.println("WishlistController::Line115::Current basket not found, creating basket.");
				orderBasket = new Order(loginDet, OrderStatus.basket);
				om.persistOrder(orderBasket);
				
				for (OrderLine ol : wishlist) 
				{
					orderLine = new OrderLine(orderBasket, ol.getProduct(), 1);	
					olm.persistOrderLine(orderLine);	
					orderLine = olm.findByProductInWishlist(ol.getProduct().getProductId());
					olm.removeProductLineFromWishlist(orderLine);	
				}
			}		
		}
	}
	
	public String getEmptyWishlist() {
		return emptyWishlist;
	}

	public void setEmptyWishlist(String emptyWishlist) {
		this.emptyWishlist = emptyWishlist;
	}
}
