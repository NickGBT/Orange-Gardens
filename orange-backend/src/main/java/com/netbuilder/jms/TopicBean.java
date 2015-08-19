package com.netbuilder.jms;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.ejb3.annotation.ResourceAdapter;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * 
 * @author Alexander Neil
 *
 */

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue.topic_in")
/*
 * Sample line of activation, Can you activate on multiple queues? Register
 * queues/topics in the standalone-full.xml
 */
})
@ResourceAdapter("activemq-ra.rar")
public class TopicBean implements MessageListener {

	@Resource(mappedName = "java:/activemq/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	// changeable or not required for sending. Can input at send-time
	@Resource(mappedName = "java:/activemq/topic_out")
	private Destination topic;

	private Connection connection;

	private static final Logger logger = LogManager.getLogger();

	public void init() throws JMSException {
		logger.info("Starting JMS connetion.");
		connection = connectionFactory.createConnection();
		connection.start();
	}

	public void destroy() throws JMSException {
		logger.info("Closing JMS connection.");
		connection.close();
	}

	/**
	 * This may not be useful. Depends if the server will be listening on any topics.
	 * Exists in case it's needed. 
	 */
	@Override
	public void onMessage(Message message) {
		// TODO Presumably inject a thing and muck it. Maybe.
		if (message instanceof TextMessage) {
			// TODO Actual functionality, imagine that.
		} else if (message instanceof ObjectMessage) {
			// TODO As above
		} else {
			logger.error("Message of unusable type received", message);
		}
	}

}
