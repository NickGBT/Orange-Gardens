package com.netbuilder.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.netbuilder.orange_dops.GladosGui;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;


/**
 * 
 * @author Alexander Neil
 *
 */
public class Receiver {

	private String broker;
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	
	public Receiver(String broker) throws JMSException{
		this.broker = broker + ":61616";
		
		connectionFactory = new ActiveMQConnectionFactory("tcp://" + this.broker);
		connection = connectionFactory.createConnection();
	}
	
	public Receiver(String broker, int port) throws JMSException{
		this.broker = broker + ":" + port;
		
		connectionFactory = new ActiveMQConnectionFactory("tcp://" + this.broker);
		connection = connectionFactory.createConnection();
	}
	
	public JmsListener listenOnQueue(String queue, GladosGui source) throws JMSException{

		try {
			connection.start();
		} catch (JMSException e) {
			System.err.println("Connection erroneous or already started.");
		}
		
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queue);
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		JmsListener jmsListener = new JmsListener(source);
		consumer.setMessageListener(jmsListener);
		
		return jmsListener;
	}
	
	public JmsListener listenOnTopic(String topic, GladosGui source) throws JMSException{
		
		try{
			connection.start();
		} catch (JMSException e){
			System.err.println("Connection erroneous or already started.");
		}
		
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createTopic(topic);
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		JmsListener jmsListener = new JmsListener(source);
		consumer.setMessageListener(jmsListener);
		
		return jmsListener;
	}
	
	public Object getMessage(String queue) throws JMSException{
		
		try{
			connection.start();
		} catch(JMSException e){
			System.err.println("Connection erroneous or already started.");
		}
		
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(queue);
		MessageConsumer consumer = session.createConsumer(destination);
		
		Message message = consumer.receive(60000);
		Object payload;
		
		if(message instanceof TextMessage){
			payload = ((TextMessage)message).getText();
		}else if(message instanceof ObjectMessage){
			payload = ((ObjectMessage)message).getObject();
		}else{
			payload = null;
			//PANIC!
		}
		
		return payload;
	}
}
