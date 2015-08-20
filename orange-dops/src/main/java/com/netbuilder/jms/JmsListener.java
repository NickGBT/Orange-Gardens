package com.netbuilder.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import com.netbuilder.jms_tools.DopsOrder;
import com.netbuilder.util.MessageHandler;

/**
 * 
 * @author Alexander Neil
 *
 */
public class JmsListener implements MessageListener {

	private final MessageHandler handler;
	private static final Logger logger = LogManager.getLogger();
	private DopsOrder fullOrder;

	public JmsListener(MessageHandler source) {
		this.handler = source;
	}

	@Override
	public void onMessage(Message message) {

		logger.info("Message received", message);
		//System.out.println("JMSLISTENER::LINE41::Received MESSAGE");

		logger.debug("Checking instance of message", message);
		if (message instanceof TextMessage) {
			try {
				String payload = ((TextMessage) message).getText();
				
				logger.debug("Handling TextMessage payload", payload);
				
			} catch (JMSException e) {
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		} 
		else if (message instanceof ObjectMessage) {
			try {
				Object payload = ((ObjectMessage) message).getObject();

				fullOrder = (DopsOrder) payload;

				logger.debug("Checking payload class type of ObjectMessage", payload);
				
			} catch (JMSException e) {
				logger.error("Error in message conversion to ObjectMessage", e);
				e.printStackTrace();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}
	
	public DopsOrder getFullOrder() {
		return fullOrder;
	}


	public void setFullOrder(DopsOrder fullOrder) {
		this.fullOrder = fullOrder;
	}
}
