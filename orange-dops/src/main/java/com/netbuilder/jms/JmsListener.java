package com.netbuilder.jms;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.pathfinding.GladosNode;
import com.netbuilder.util.MessageHandler;

/**
 * 
 * @author Alexander Neil
 *
 */
public class JmsListener implements MessageListener {

	private final MessageHandler handler;
	private static final Logger logger = LogManager.getLogger();

	public JmsListener(MessageHandler source) {
		this.handler = source;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {

		logger.info("Message received", message);

		logger.debug("Checking instance of message", message);
		if (message instanceof TextMessage) {
			try {
				String payload = ((TextMessage) message).getText();
				
				logger.debug("Handling TextMessage payload", payload);
				handler.addTempProduct(payload);
			} catch (JMSException e) {
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		} else if (message instanceof ObjectMessage) {
			try {
				Object payload = ((ObjectMessage) message).getObject();

				logger.debug("Checking payload class type of ObjectMessage", payload);
				
				if (payload instanceof List<?>) {
					handler.setTempPath((List<GladosNode>)payload);
				}
			} catch (JMSException e) {
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		}
	}

}
