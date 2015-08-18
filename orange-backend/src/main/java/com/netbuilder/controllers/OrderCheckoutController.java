package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.OrderLineManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.jms.QueueSenderBean;
import com.netbuilder.jms_tools.DopsOrder;
import com.netbuilder.jms_tools.DopsOrderline;
import com.netbuilder.jms_tools.GladosNode;
import com.netbuilder.util.OrderDetails;
import com.netbuilder.util.OrderData;
import com.netbuilder.util.UserId;

/**
 * 
 * @author ngilbert llew
 *
 *
 **/

@ManagedBean(name = "orderCheckoutController")
@RequestScoped
public class OrderCheckoutController {
	@ManagedProperty(value = "#{testData}")
	private OrderData testData;

	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	@Inject
	private QueueSenderBean qb;

	@Inject
	private AddressManager address;
	private LoginDetails loginDet;

	@Inject
	private PaymentDetailsManager paymentDetails;

	@Inject
	private OrderManager orderManager;

	@Inject
	private OrderLineManager orderLineManager;

	private DopsOrder dopsOrder;

	private Order order;
	private OrderDetails basketDetails;

	@Inject
	private UserId userId;

	private PaymentDetails pd;
	private Address ad;

	private String username;
	private ArrayList<GladosNode> path;
	private GladosNode gladosNode;
	private ArrayList<DopsOrderline> tempDopsOrders;

	public String changeOrderStatus() {

		username = userId.getUsername();
		path = new ArrayList<GladosNode>();
		tempDopsOrders = new ArrayList<DopsOrderline>();

		order = orderManager.findBasketByUsername(OrderStatus.basket, username);

		if (order.getOrderStatus() == OrderStatus.basket) {

			orderLines = orderLineManager.getBasketOrderLines(username);

			for (OrderLine ol : orderLines) {
				if (ol.getProduct().getProductName() == "Garden Light") {
					gladosNode = new GladosNode(18, 6);
					path.add(gladosNode);
				}
				if (ol.getProduct().getProductName() == "Cool Gnome") {
					gladosNode = new GladosNode(6, 12);
					path.add(gladosNode);
				}
				if (ol.getProduct().getProductName() == "Relaxation Chair") {
					gladosNode = new GladosNode(3, 3);
					path.add(gladosNode);
				}
				if (ol.getProduct().getProductName() == "Swag Shed") {
					gladosNode = new GladosNode(12, 17);
					path.add(gladosNode);
				}
				
				DopsOrderline dol = new DopsOrderline(ol.getProduct()
						.getProductName(), Integer.toString(ol.getQuantity()),
						Integer.toString(ol.getProduct().getHeight()), path);
				tempDopsOrders.add(dol);
				//System.out.println("OrderCheckout::Line113:: Location: " +  path.get(0).getxPosition() + ":" + path.get(0).getyPosition());
				path.clear();
			}

			dopsOrder = new DopsOrder(tempDopsOrders);

			qb.sendMessage("dops_queue", dopsOrder);
			order.setStatus(OrderStatus.placed);
			return "confirmationpage.xhtml";
			// order = new Order(loginDet, OrderStatus.basket, null);
			// orderManager.persistOrder(order);
		} else
			return "#";
	}

	public Order getOrder() {
		order = orderManager.findBasketByUsername(OrderStatus.basket,
				userId.getUsername());
		// order = testData.getOrder();
		return order;
	}

	public List<OrderLine> getBasket() {
		// orderLines = testData.getOrderLines();
		return orderLines;
		// return basketDetails.getBasket();
	}

	public PaymentDetails getPaymentDetails() {
		pd = paymentDetails.findCustomerPaymentDetails(userId.getUid());
		return pd;
	}

	public Address getAddress() {
		return ad = address.findByUserId(userId.getUid());
	}

	public OrderData getTestData() {
		return testData;
	}

	public void setTestData(OrderData testData) {
		this.testData = testData;
	}

	public CardType[] getEnumValues() {
		return CardType.values();
	}
}
