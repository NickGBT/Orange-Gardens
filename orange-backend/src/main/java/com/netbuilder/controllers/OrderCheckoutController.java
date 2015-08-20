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
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
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
	private LoginDetailsManager loginManager;

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

	private ArrayList<GladosNode> path;
	private GladosNode gladosNode;
	private ArrayList<DopsOrderline> tempDopsOrders;

	public String changeOrderStatus() {

		tempDopsOrders = new ArrayList<DopsOrderline>();

		order = orderManager.findBasketByUserId(OrderStatus.basket, loginManager.findByUserId(userId.getUid()));

		if (order.getOrderStatus() == OrderStatus.basket) {

			orderLines = orderLineManager.getBasketOrderLines(order);

			for (OrderLine ol : orderLines) {
				if (ol.getProduct().getProductName() == "Garden Light") {
					gladosNode = new GladosNode(18, 6);
				}
				if (ol.getProduct().getProductName() == "Cool Gnome") {
					gladosNode = new GladosNode(6, 12);

				}
				if (ol.getProduct().getProductName() == "Relaxation Chair") {
					gladosNode = new GladosNode(3, 3);
				}
				if (ol.getProduct().getProductName() == "Swag Shed") {
					gladosNode = new GladosNode(12, 17);
				}
				
				DopsOrderline dol = new DopsOrderline(ol.getProduct()
						.getProductName(), Integer.toString(ol.getQuantity()),
						Integer.toString(ol.getProduct().getHeight()), gladosNode);
				tempDopsOrders.add(dol);
				//System.out.println("OrderCheckout::Line113:: Location: " +  gladosNode.getxPosition() + ":" + gladosNode.getyPosition());
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
		return orderManager.findBasketByUserId(OrderStatus.basket, loginManager.findByUserId(userId.getUid()));
	}
	
	/**
	 * @author JustinMabbutt
	 * Get the order that is has been confirmed
	 * @return the confirmed order
	 */
	public Order getConfirmed()
	{
		loginDet = loginManager.findByUserId(userId.getUid());
		return orderManager.findBasketByUserId(OrderStatus.placed, loginDet);	
	}

	public List<OrderLine> getBasket() {
		return orderLineManager.getBasketOrderLines(orderManager.findBasketByUserId(OrderStatus.basket,	loginManager.findByUserId(userId.getUid())));
	}
	
	public PaymentDetails getPaymentDetails(){
		return paymentDetails.findCustomerPaymentDetails(loginManager.findByUserId(userId.getUid()));
	}
	
	public Address getAddress(){
		return address.findByUserId(loginManager.findByUserId(userId.getUid()));
	} 

	public void setTestData(OrderData testData) {
		this.testData = testData;
	}

	public CardType[] getEnumValues() {
		return CardType.values();
	}
}
