package com.netbuilder.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Alexander Neil
 *
 */

public class Sender {

	private static final Logger logger = LogManager.getLogger();

	private String broker;
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;

	public Sender(String broker) throws JMSException {
		this.broker = broker + ":61616";

		logger.info("Using default port for broker (61616)");
		connectionFactory = new ActiveMQConnectionFactory("tcp://"
				+ this.broker);
		logger.debug("Creating connection for \"tcp://" + this.broker + "\".");
		connection = connectionFactory.createConnection();
	}

	public Sender(String broker, int port) throws JMSException {
		this.broker = broker + ":" + port;

		logger.info("Using default port for broker (61616)");
		connectionFactory = new ActiveMQConnectionFactory("tcp://"
				+ this.broker);
		logger.debug("Creating connection for \"tcp://" + this.broker + "\".");
		connection = connectionFactory.createConnection();
	}

	public void sendToQueue(String payload, String destinationQueue)
			throws JMSException {

		try {
			connection.start();
		} catch (JMSException e) {
			logger.warn("Connection error or already started", e);
			System.err.println("Connection erroneous or already started.");
		}
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

		logger.debug("Defining destination.", destinationQueue);
		Destination destination = session.createQueue(destinationQueue);
		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage(payload);

		logger.debug("Sending message.", message);
		producer.send(message);

		logger.info("Attempting to close connection");
		session.close();
		connection.close();
	}

	public void sendToQueue(Serializable payload, String destinationQueue)
			throws JMSException {

		try {
			connection.start();
		} catch (JMSException e) {
			logger.warn("Connection error or already started", e);
			System.err.println("Connection erroneous or already started.");
		}
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

		logger.debug("Defining destination.", destinationQueue);
		Destination destination = session.createQueue(destinationQueue);
		MessageProducer producer = session.createProducer(destination);

		ObjectMessage message = session.createObjectMessage(payload);

		logger.debug("Sending message.", message);
		producer.send(message);

		logger.info("Attempting to close connection");
		session.close();
		connection.close();
	}
}
