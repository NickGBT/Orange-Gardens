package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.LoginDetailsManager;
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

	private static final Logger logger = LogManager.getLogger();

	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	@Inject
	private AddressManager address;
	private LoginDetails loginDet;
	
	@Inject
	private PaymentDetailsManager paymentDetails;
	private LoginDetailsManager loginManager;

	@Inject
	private OrderManager orderManager;
	private Order order, confirmed;
	private OrderDetails basketDetails;
	
	@Inject
	private UserId userId;
	
	private PaymentDetails pd;
	private Address ad;
	
	public String changeOrderStatus(){
		loginDet = loginManager.findByUserId(userId.getUid());
		order = orderManager.findBasketByUserId(OrderStatus.basket, loginDet);
		order.setStatus(OrderStatus.placed);
		
		if(order.getOrderStatus() == OrderStatus.placed){
			return "confirmationpage.xhtml";
			//order = new Order(loginDet, OrderStatus.basket, null);
			//orderManager.persistOrder(order);
		}
		else 
			logger.info("Order failed", order);
			return "#";
	}
	

	public Order getOrder() {
		loginDet = loginManager.findByUserId(userId.getUid());
		order = orderManager.findBasketByUserId(OrderStatus.basket, loginDet);
		//order = testData.getOrder();
		return order;
	}
	
	/**
	 * @author JustinMabbutt
	 * Get the order that is has been confirmed
	 * @return the confirmed order
	 */
	public Order getConfirmed()
	{
		loginDet = loginManager.findByUserId(userId.getUid());
		confirmed = orderManager.findBasketByUserId(OrderStatus.placed, loginDet);
		return confirmed;
	}

	public List<OrderLine> getBasket() {
		// orderLines = testData.getOrderLines();
		return orderLines;
		// return basketDetails.getBasket();
	}
	
	public PaymentDetails getPaymentDetails(){
		//pd = paymentDetails.findCustomerPaymentDetails(userId.getUid());
		return pd;
	}
	
	public Address getAddress(){
		//return ad = address.findByUserId(userId.getUid()); 
		return null;
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
