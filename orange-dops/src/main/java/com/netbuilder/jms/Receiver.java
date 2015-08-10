package com.netbuilder.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbuilder.orange_dops.GladosGui;

/**
 * 
 * @author Alexander Neil
 *
 */
public class Receiver {

	private static final Logger logger = LogManager.getLogger();

	private String broker;
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;

	public Receiver(String broker) throws JMSException {
		this.broker = broker + ":61616";
		logger.info("Using default port for broker (61616)");
		connectionFactory = new ActiveMQConnectionFactory("tcp://"
				+ this.broker);
		logger.debug("Creating connection for \"tcp://" + this.broker + "\".");
		connection = connectionFactory.createConnection();
	}

	public Receiver(String broker, int port) throws JMSException {
		this.broker = broker + ":" + port;

		connectionFactory = new ActiveMQConnectionFactory("tcp://"
				+ this.broker);
		logger.debug("Creating connection for \"tcp://" + this.broker + "\".");
		connection = connectionFactory.createConnection();
	}

	public JmsListener listenOnQueue(String queue, GladosGui source)
			throws JMSException {

		try {
			connection.start();
		} catch (JMSException e) {
			logger.warn("Connection error or already started", e);
			System.err.println("Connection erroneous or already started.");
		}

		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queue);

		MessageConsumer consumer = session.createConsumer(destination);

		JmsListener jmsListener = new JmsListener(source);
		logger.debug("Setting JmsListener for queue:\"" + queue + "\"",
				jmsListener);
		consumer.setMessageListener(jmsListener);

		return jmsListener;
	}

	public JmsListener listenOnTopic(String topic, GladosGui source)
			throws JMSException {

		try {
			connection.start();
		} catch (JMSException e) {
			logger.warn("Connection error or already started", e);
			System.err.println("Connection erroneous or already started.");
		}

		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic(topic);

		MessageConsumer consumer = session.createConsumer(destination);

		JmsListener jmsListener = new JmsListener(source);
		logger.debug("Setting JmsListener for queue:\"" + topic + "\"",
				jmsListener);
		consumer.setMessageListener(jmsListener);

		return jmsListener;
	}

	public Object getMessage(String queue) throws JMSException {

		logger.info("Preparing to wait on a message queue");
		try {
			connection.start();
		} catch (JMSException e) {
			logger.warn("Connection error or already started", e);
			System.err.println("Connection erroneous or already started.");
		}

		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queue);
		MessageConsumer consumer = session.createConsumer(destination);

		logger.info("Setting timeout for blocking call to 60 seconds");
		Message message = consumer.receive(60000);
		Object payload;

		logger.debug("Checking type of message received");
		if (message instanceof TextMessage) {
			payload = ((TextMessage) message).getText();
			logger.debug("Unpacking TextMessage to payload object", payload);
		} else if (message instanceof ObjectMessage) {
			payload = ((ObjectMessage) message).getObject();
			logger.debug("Unpacking ObjectMessage to payload object", payload);
		} else {
			logger.error("Message received is not next or object. Returning null");
			return null;
		}
		return payload;
	}
}
