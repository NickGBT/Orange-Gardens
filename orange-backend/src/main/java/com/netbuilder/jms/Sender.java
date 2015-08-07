package com.netbuilder.jms;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

@Stateless
@ManagedBean(value="Sender")
public class Sender {

	private static final Logger logger = LogManager.getLogger();
	
	Connection connection;
	Session session;
	
	public void sentToQueue(String payload, String destinationQueue){
		
	try {
		logger.info("Getting context and looking up connection factory");
		Context context = new InitialContext();
		ActiveMQConnectionFactory connectionFactory = (ActiveMQConnectionFactory) context.lookup("java:jboss/exported/ConnectionFactory");
		
		logger.debug("Creating connection from the factory's settings.");
		connection = connectionFactory.createConnection();
		logger.info("Attempting to start the connection", connection);
		connection.start();
		logger.info("Successfully connected!");
		
		session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(destinationQueue);
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage(payload);
		
		logger.debug("Sending message", message);
		producer.send(message);
		
		connection.close();
		
	} catch (NamingException e) {
		logger.error("Error getting context or looking up connection factory", e);
		e.printStackTrace();
	} catch (JMSException e) {
		logger.error("Error in JMS sending procedure.", e);
		e.printStackTrace();
	} finally{
		if(session != null){
			try {
				session.close();
			} catch (JMSException e) {
				logger.info("Session closing error, or was never started.", e);
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (JMSException e) {
				logger.info("Connection closing error, or was never started.", e);
				e.printStackTrace();
			}
		}
	}
	
	}
}
