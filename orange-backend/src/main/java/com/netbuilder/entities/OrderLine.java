package com.netbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author llew
 *
 */

@Entity
@Table(name = "order_line")
@NamedQueries({
	@NamedQuery(name = OrderLine.FIND_BY_PRODUCT_ID, query = "SELECT o FROM OrderLine o WHERE o.product = :product"),
	@NamedQuery(name = OrderLine.FIND_BY_ORDER_ID, query = "SELECT o FROM OrderLine o WHERE o.order = :order"),
	@NamedQuery(name = OrderLine.FIND_BY_QUANTITY, query = "SELECT o FROM OrderLine o WHERE o.quantity = :quantity"),
	@NamedQuery(name = OrderLine.GET_ALL, query = "SELECT o FROM OrderLine o"),
	@NamedQuery(name = OrderLine.GET_PRODUCT_IN_BASKET, query = "SELECT o FROM OrderLine o WHERE o.order = :productID")})
public class OrderLine implements Serializable {
	
	private static final long serialVersionUID = 106177606691863253L;
	public static final String GET_ALL = "OrderLine.getOrderLine";
	public static final String FIND_BY_ORDER_ID = "OrderLine.findByOrderId";
	public static final String FIND_BY_PRODUCT_ID = "OrderLine.findByProductId";
	public static final String FIND_BY_QUANTITY = "OrderLine.findByQuantity";
	public static final String GET_PRODUCT_IN_BASKET = "OrderLine.findByProductInBasket";

	@Id
	@Column(name = "orderline_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int orderLineId;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@NotNull
	private Order order;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	@NotNull
	private Product product;

	@Column(name = "quantity", nullable = true)
	@NotNull
	private int quantity;

	public OrderLine(Order order, Product product, int quantity) {

		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	public OrderLine(){}

	public OrderLine(Order orderId, Product productId) {
		this.order = orderId;
		this.product = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setOrderID(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setProductID(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}