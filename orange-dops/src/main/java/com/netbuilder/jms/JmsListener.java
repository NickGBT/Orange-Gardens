package com.netbuilder.jms;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger logger = LogManager.getLogger();
	
	public JmsListener(GladosGui source){
		this.handler = source;
	}
	
	@Override
	public void onMessage(Message message) {
		
		logger.info("Message received", message);
	
		logger.debug("Checking instance of message", message);
		if(message instanceof TextMessage){
			try {
				String payload = ((TextMessage) message).getText();
				
				logger.debug("Handling TextMessage payload", payload);
				//TODO Use payload
			} catch (JMSException e) {
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		} else if(message instanceof ObjectMessage){
			try {
				Object payload = ((ObjectMessage)message).getObject();
				
				logger.debug("Checking payload class type of ObjectMessage", payload);
				if(payload instanceof List<?>){
					
				}
			} catch (JMSException e) {
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		}
	}

}
