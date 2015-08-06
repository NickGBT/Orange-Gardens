package com.netbuilder.jms.sender;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class Sender {

	private String broker;
	private ActiveMQConnectionFactory connectionFactory;
	private Connection connection;
	
	public Sender(String broker) throws JMSException{
		this.broker = broker;
		
		connectionFactory = new ActiveMQConnectionFactory("tcp://" + broker);
		connection = connectionFactory.createConnection();
	}
	
	public Sender(String broker, int port) throws JMSException{
		this.broker = broker + ":" + port;
		
		connectionFactory = new ActiveMQConnectionFactory("tcp://" + broker);
		connection = connectionFactory.createConnection();
	}
	
	public void send(String payload, String destination) throws JMSException{
		
		connection.start();
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		
		Destination dest = session.createQueue(destination);
		MessageProducer producer = session.createProducer(dest);
		
		TextMessage message = session.createTextMessage(payload);
		
		producer.send(message);
		
		session.close();
		connection.close();
	}
	
	public void send(Serializable payload, String destination){
		
	}
}
