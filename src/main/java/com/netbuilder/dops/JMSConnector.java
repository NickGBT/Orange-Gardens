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


public class JMSConnector implements MessageListener {

	ArrayList<Integer> activeEmployees;
	
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
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
