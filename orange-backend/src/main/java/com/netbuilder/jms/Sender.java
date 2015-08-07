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

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

@Stateless
@ManagedBean(value="Sender")
public class Sender {

	public void sentToQueue(String payload, String destinationQueue){
		
	Context context;
	try {
		context = new InitialContext();
		ActiveMQConnectionFactory connectionFactory = (ActiveMQConnectionFactory) context.lookup("java:jboss/exported/ConnectionFactory");
		
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(destinationQueue);
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage(payload);
		
		producer.send(message);
		
		session.close();
		connection.close();
		
	} catch (NamingException e) {
		e.printStackTrace();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
