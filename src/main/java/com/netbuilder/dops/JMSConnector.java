package com.netbuilder.dops;

import java.util.ArrayList;

import javax.jms.Message;
import javax.jms.MessageListener;

import com.netbuilder.entities.Order;

/**
 * 
 * @author Alexander Neil
 *
 */


public class JMSConnector{

	ArrayList<Integer> activeEmployees;
	
	MessageSender sender;
	MessagePublisher publisher;
	//MessageReceiver receiver;
	
	public JMSConnector(){
		activeEmployees = new ArrayList<Integer>();
		
		listenForLogin();
		listenForRequests();
	}
	
	void listenForLogin(){
		
	}
	
	public int assignOrder(Order order){
		return -1;
	}
	
	void listenForRequests(){
		
	}

	
	//Test method
	
}
