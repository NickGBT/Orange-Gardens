package com.netbuilder.entity_managers.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;

import com.netbuilder.entities.OrderLine;

/**
 * 
 * @author mwatson llew
 *
 */
@RequestScoped
public interface OrderLineManager {

	// CREATE
	public void persistOrderLine(OrderLine orderLine);

	public void persistOrderLine(List<OrderLine> orderLine);

	// READ
	public OrderLine findByProductId(int productID);
	
	public OrderLine findByProductInBasket(int productID);
	
	public ArrayList<OrderLine> findProductsPlaced(String username);
	
	public OrderLine findByProductInWishlist(int productID);

	public List<OrderLine> findByOrderId(int orderId);

	public List<OrderLine> findByQuantity(int quantity);

	public List<OrderLine> getOrderLine();

	public List<OrderLine> getBasketOrderLines(String username);
	
	public List<OrderLine> getWishlistOrderLines(String username);

	// UPDATE
	public void updateOrderLine(OrderLine orderLine);

	// DELETE
	public void removeProductLine(OrderLine orderLine);
	
	public void removeProductLineFromWishlist(OrderLine orderLine);
}
