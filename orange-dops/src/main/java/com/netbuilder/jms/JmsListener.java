package com.netbuilder.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.netbuilder.orange_dops.GladosGui;

/**
 * 
 * @author Alexander Neil
 *
 */
public class JmsListener implements MessageListener {

	private final GladosGui handler;
	
	public JmsListener(GladosGui source){
		this.handler = source;
	}
	
	@Override
	public void onMessage(Message message) {
		
		if(message instanceof TextMessage){
			try {
				String payload = ((TextMessage) message).getText();
				
				//TODO Use payload
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else if(message instanceof ObjectMessage){
			try {
				Object payload = ((ObjectMessage)message).getObject();
				
				//TODO Use received object
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
