package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.netbuilder.dops.GladosNode;
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
import com.netbuilder.util.DopsOrder;
import com.netbuilder.util.DopsOrderline;
import com.netbuilder.util.OrderDetails;
import com.netbuilder.util.TestData;
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
	private TestData testData;

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
	
	public String changeOrderStatus(){
		
		username = userId.getUsername();
		path = new ArrayList<GladosNode>();
		tempDopsOrders = new ArrayList<DopsOrderline>();
		
		gladosNode = new GladosNode(5,5);
		path.add(gladosNode);
		order = orderManager.findBasketByUsername(OrderStatus.basket, username);
		order.setStatus(OrderStatus.placed);
		
		if(order.getOrderStatus() == OrderStatus.placed){
			
			orderLines = orderLineManager.getBasketOrderLines(username);
			
			for (OrderLine ol : orderLines) {
				DopsOrderline dol = new DopsOrderline(ol.getProduct().getProductName(), Integer.toString(ol.getQuantity()), Integer.toString(ol.getProduct().getHeight()),path );
				tempDopsOrders.add(dol);				
			}
			
			dopsOrder = new DopsOrder(tempDopsOrders);
			
			qb.sendMessage("dops_queue", dopsOrder);
			
			return "confirmationpage.xhtml";
			//order = new Order(loginDet, OrderStatus.basket, null);
			//orderManager.persistOrder(order);
		}
		else 
			return "#";
	}
	

	public Order getOrder() {
		order = orderManager.findBasketByUsername(OrderStatus.basket, userId.getUsername());
		//order = testData.getOrder();
		return order;
	}

	public List<OrderLine> getBasket() {
		// orderLines = testData.getOrderLines();
		return orderLines;
		// return basketDetails.getBasket();
	}
	
	public PaymentDetails getPaymentDetails(){
		pd = paymentDetails.findCustomerPaymentDetails(userId.getUid());
		return pd;
	}
	
	public Address getAddress(){
		return ad = address.findByUserId(userId.getUid()); 
	} 
	
	public TestData getTestData() {
		return testData;
	}

	public void setTestData(TestData testData) {
		this.testData = testData;
	}
	
	public CardType[] getEnumValues(){
		return CardType.values();
	}
}
