package com.netbuilder.controllers;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.jms.QueueSenderBean;
import com.netbuilder.util.TestData;

@ManagedBean(name = "messageController")
@RequestScoped
public class MessageController 
{
	@Inject
	private QueueSenderBean qb;
	
//	@ManagedProperty(value = "#{testData}")
//	private TestData testData;
	
//	@Inject
//	private Order order;
//	
//	public MessageController()
//	{
//		this.order = testData.order;	
//	}

	
	private String textMessage = "Hello from Message Controller!";

	public void sendTextMessage()
	{
		System.out.println("SENDING");
		qb.sendMessage("dops_queue",textMessage);
	}
	
	public void sendOrder()
	{
		System.out.println("MessageController::Line27::Sending Order");
//		qb.sendMessage("dops_queue", order);
	}
	
	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

//	public TestData getTestData() {
//		return testData;
//	}
//
//	public void setTestData(TestData testData) {
//		this.testData = testData;
//	}
	
	
}
