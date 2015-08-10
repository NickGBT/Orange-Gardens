package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;
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
	private AddressManager address;

	@Inject
	private PaymentDetailsManager paymentDetails;

	@Inject
	private OrderManager orderManager;
	private Order order;
	private OrderDetails basketDetails;

	@Inject
	private UserId userId;
	
	private PaymentDetails pd;
	private Address ad;
	
	public String changeOrderStatus(){
		order = orderManager.findBasketByUsername(OrderStatus.basket, userId.getUsername());
		order.setStatus(OrderStatus.placed);
		if(order.getOrderStatus() == OrderStatus.placed){
			return "confirmationpage.xhtml";
		}
		
		else 
			return "#";
	}
	

	public Order getOrder() {
		// order = orderManager.findByOrderID(orderId.getOrderId());
		order = testData.getOrder();
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
