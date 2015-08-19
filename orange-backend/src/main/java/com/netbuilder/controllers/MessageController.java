package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.jms.QueueSenderBean;
import com.netbuilder.jms_tools.DopsOrder;
import com.netbuilder.jms_tools.DopsOrderline;
import com.netbuilder.jms_tools.GladosNode;

@ManagedBean(name = "messageController")
@RequestScoped
public class MessageController 
{
	@Inject
	private QueueSenderBean qb;
	
	private DopsOrderline dopsOrderline;
	private DopsOrder dopsOrder;
	private ArrayList<GladosNode> path;
	private ArrayList<DopsOrderline> dopsOrderTemp;
	private GladosNode gladosNode;
	
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
	//private Serializable object = new Serializable();
	private Product product;


	public void sendTextMessage()
	{
		System.out.println("SENDING");
		qb.sendMessage("dops_queue",textMessage);
	}
	
	public void sendOrder()
	{
		path = new ArrayList<GladosNode>();
		dopsOrderTemp = new ArrayList<DopsOrderline>();
		
		gladosNode = new GladosNode(5,5);
		path.add(gladosNode);
		dopsOrderline = new DopsOrderline("Gnome", "2", "B1", gladosNode);
		dopsOrderTemp.add(dopsOrderline);
		dopsOrder = new DopsOrder(dopsOrderTemp);
		
		System.out.println("MessageController::Line27::Sending Order");
		qb.sendMessage("dops_queue", dopsOrder);
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
