package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author llew
 *
 */

@Alternative
@Singleton
public class OrderLineManagerAL implements OrderLineManager {

	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();

	public void persistOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}

	public void persistOrderLine(List<OrderLine> orderLine) {
		orderLines.addAll(orderLine);
	}

	public OrderLine findByProductId(int productID) {
		for (OrderLine o : orderLines) {
			if (o.getProduct().getProductId() == productID) {
				return o;
			}
		}
		return null;
	}
	
	public OrderLine findByProductInBasket(int productID) {
		for (OrderLine o : orderLines) {
			if (o.getProduct().getProductId() == productID && 
					o.getOrder().getOrderStatus() == OrderStatus.basket) {
				return o;
			}
		}
		return null;
	}
	
	public ArrayList<OrderLine> findProductsPlaced(String username) {
		ArrayList<OrderLine> ol = new ArrayList<OrderLine>();
		
		for (OrderLine o : orderLines) {
			if (o.getOrder().getCustomer().getUsername().equals(username) && 
					o.getOrder().getOrderStatus() == OrderStatus.placed) {
				ol.add(o);
			}
		
		}
		return ol;
	}
	
	/**
	 * 
	 * @author jtaylor
	 *  
	 */
	public OrderLine findByProductInWishlist(int productID) 
	{
		for (OrderLine o : orderLines) 
		{
			if (o.getProduct().getProductId() == productID && 
					o.getOrder().getOrderStatus() == OrderStatus.wishlist) 
			{
				return o;
			}
		}
		return null;
	}

	public List<OrderLine> findByOrderId(int orderId) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>();
		for (OrderLine o : orderLines) {
			if (o.getOrder().getOrderId() == orderId) {
				orderLine.add(o);
			}
		}
		return orderLine;
	}

	public List<OrderLine> findByQuantity(int quantity) {
		List<OrderLine> orderLine = new ArrayList<OrderLine>();
		for (OrderLine o : orderLine) {
			if (o.getQuantity() == quantity) {
				orderLine.add(o);
			}
		}

		if (orderLine.isEmpty())
			return orderLine;
		else
			return null;

	}

	public List<OrderLine> getOrderLine() {
		return orderLines;
	}

	/*
	 * 
	 * @author jtaylor
	 */
	public void updateOrderLine(OrderLine orderLine) {
		for (OrderLine o : orderLines) {
			if (o.getOrder().getCustomer().getUsername()
					.equals(orderLine.getOrder().getCustomer().getUsername())) {
				if (orderLine.getProduct().getProductId() == o.getProduct()
						.getProductId()) {
					orderLines.set(orderLines.indexOf(o), orderLine);
				}
			}
		}
	}

	/*
	 * 
	 * @author jtaylor
	 */
	public void removeProductLine(OrderLine orderLine) {
		ArrayList<OrderLine> toRemove = new ArrayList<OrderLine>();
		for (OrderLine o : orderLines) {
			if (o.getOrder().getCustomer().getUsername()
					.equals(orderLine.getOrder().getCustomer().getUsername())) {
				if (orderLine.getProduct().getProductId() == o.getProduct()
						.getProductId()) {
					toRemove.add(o);
				}
			}
		}
		orderLines.removeAll(toRemove);
	}
	
	/*
	 * 
	 * @author jtaylor
	 */
	public void removeProductLineFromWishlist(OrderLine orderLine) {
		ArrayList<OrderLine> toRemove = new ArrayList<OrderLine>();
		for (OrderLine o : orderLines) {
			if (o.getOrder().getCustomer().getUsername()
					.equals(orderLine.getOrder().getCustomer().getUsername())) {
				if (orderLine.getProduct().getProductId() == o.getProduct()
						.getProductId() && o.getOrder().getOrderStatus() == OrderStatus.wishlist) {
					toRemove.add(o);
				}
			}
		}
		orderLines.removeAll(toRemove);
	}

	public void updateProductLine(OrderLine orderLine) {
		for (OrderLine o : orderLines) {
			if (o.getOrder().getOrderId() == orderLine.getOrder().getOrderId()) {
				orderLines.set(orderLines.indexOf(o), orderLine);
			}
		}
	}

	public List<OrderLine> getBasketOrderLines(Order order) {
		ArrayList<OrderLine> userOrderLines = new ArrayList<OrderLine>();
		for (OrderLine o : orderLines) {
			if (o.getOrder().getCustomer().getUsername().equals(order.getCustomer().getUsername())
					&& o.getOrder().getOrderStatus() == OrderStatus.basket) {
				userOrderLines.add(o);
			}
		}

		return userOrderLines;
	}
	
	public List<OrderLine> getWishlistOrderLines(Order order) {
		ArrayList<OrderLine> userOrderLines = new ArrayList<OrderLine>();
		for (OrderLine ol : orderLines) {
			if (ol.getOrder().getCustomer().getUsername().equals(order.getCustomer().getUsername()) && ol.getOrder().getOrderStatus() == OrderStatus.wishlist) {
				userOrderLines.add(ol);
			}
		}
		return userOrderLines;
	}
}
