package com.netbuilder.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.ejb3.annotation.ResourceAdapter;

import com.netbuilder.jms_tools.DopsOrder;

@Named(value="queueSender")
@Stateless
@ResourceAdapter("activemq-ra.rar")
public class QueueSenderBean {

	@Resource(mappedName = "java:/activemq/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:/activemq/queue_out")
	private Destination queue;
//	@Resource(mappedName = "java:/activemq/dops_queue")
//	private Destination dopsQueue;
	
	private Connection connection;
	
	private static final Logger logger = LogManager.getLogger();

	
	public void init() throws JMSException {
		logger.info("Starting JMS connecton.");
		connection = connectionFactory.createConnection();
		connection.start();
	}

	public void destroy() throws JMSException {
		logger.info("Closing JMS connection.");
		connection.close();
	}
	
	/**
	 * Sends to destination specified in the Destination resource injection
	 * 
	 * @param text Text to be sent as a JMS message
	 */
	public void sendMessage(String text) {
		logger.debug("Sending text message");
		Session session = null;
		MessageProducer producer = null;
		try {
			init();

			session = connection.createSession(true, AUTO_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			TextMessage message = session.createTextMessage(text);
			logger.info("Attempting to send message.", message);
			producer.send(message);

		} catch (JMSException e) {

		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing message producer. May not have been created properly.");
			}
			try {
				if (producer != null) {
					session.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing session. May not have been created properly.");
			}
			try {
				destroy();
			} catch (JMSException e) {
				logger.info("Issue closing connection. May not have been created properly.");
			}
		}
	}

	/**
	 * Sends to destination specified in the Destination resource injection
	 * 
	 * @param object Serializable object to be sent as a JMS message
	 */
	public void sendMessage(Serializable object) {
		Session session = null;
		MessageProducer producer = null;

		try {
			init();

			session = connection.createSession(true, AUTO_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			ObjectMessage message = session.createObjectMessage(object);
			producer.send(message);

		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing message producer. May not have been created properly.");
			}
			try {
				if (producer != null) {
					session.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing session. May not have been created properly.");
			}
			try {
				destroy();
			} catch (JMSException e) {
				logger.info("Issue closing connection. May not have been created properly.");
			}
		}
	}
	
	/**
	 * Sends to destination specified in the Destination resource injection
	 * @param destination Name of the queue to send a message to
	 * @param text Text to be sent as a JMS message
	 */
	public void sendMessage(String destination, String text) {
		logger.debug("Sending text message");
		Session session = null;
		MessageProducer producer = null;
		try {
			init();
			
			session = connection.createSession(true, AUTO_ACKNOWLEDGE);
			queue = session.createQueue(destination);
			
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			TextMessage message = session.createTextMessage(text);
			logger.info("Attempting to send message.", message);
			producer.send(message);

		} catch (JMSException e) {

		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing message producer. May not have been created properly.");
			}
			try {
				if (producer != null) {
					session.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing session. May not have been created properly.");
			}
			try {
				destroy();
			} catch (JMSException e) {
				logger.info("Issue closing connection. May not have been created properly.");
			}
		}
	}

	/**
	 * Sends to destination specified as a parameter
	 * @param destination Name of queue to send message to
	 * @param object Serializable object to be sent as a JMS message
	 */
	public void sendMessage(String destination, DopsOrder dopsOrder) {
		Session session = null;
		MessageProducer producer = null;

		try {
			init();

			session = connection.createSession(true, AUTO_ACKNOWLEDGE);
			queue = session.createQueue(destination);
			
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			ObjectMessage message = session.createObjectMessage(dopsOrder);
			producer.send(message);

		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing message producer. May not have been created properly.");
			}
			try {
				if (producer != null) {
					session.close();
				}
			} catch (JMSException e) {
				logger.info("Issue closing session. May not have been created properly.");
			}
			try {
				destroy();
			} catch (JMSException e) {
				logger.info("Issue closing connection. May not have been created properly.");
			}
		}
	}
	
}
