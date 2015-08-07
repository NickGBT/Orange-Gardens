package com.netbuilder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.interfaces.AddressManager;
import com.netbuilder.entity_managers.interfaces.OrderManager;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.util.TestData;
import com.netbuilder.util.UserId;
import com.netbuilder.util.OrderDetails;
/**
 * 
 * @author ngilbert llew
 *
 *
 **/

@ManagedBean (name = "orderCheckoutController")
@RequestScoped
public class OrderCheckoutController 
{
	@ManagedProperty(value= "#{testData}")
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
	
	public void testMethod(){
		System.out.println("test");
	}
	
	public Order getOrder() 
	{
		//order = orderManager.findByOrderID(orderId.getOrderId());
		order= testData.getOrder();
		return order;
	}
	 
	public List<OrderLine> getBasket(){
		//orderLines = testData.getOrderLines();
		return orderLines;
		//return basketDetails.getBasket();
	}
	
	public PaymentDetails getPaymentDetails(){
		return paymentDetails.findCustomerPaymentDetails(userId.getUid());
	}
	
	public Address getAddress(){
		return address.findByUserId(userId.getUid()); 
	} 
	
	public TestData getTestData() {
		return testData;
	}

	public void setTestData(TestData testData) {
		this.testData = testData;
	}
}
