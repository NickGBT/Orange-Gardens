package com.netbuilder.dops.jms;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * 
 * @author Alexander Neil
 *
 */
public class MessagePublisher {

	private Context context = null;
	private TopicConnectionFactory connFactory =  null;
	private TopicConnection conn = null;
	private Topic topic = null;
	private TopicSession session = null;
	private TopicPublisher tPublisher = null;
	
	public void sendOrdersAvailable(ArrayList<Integer> orderIds){
		try{
			context = new InitialContext();
			connFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
			topic = (Topic) context.lookup("orderavailable");
			conn = connFactory.createTopicConnection();
			session = conn.createTopicSession(false, AUTO_ACKNOWLEDGE);
			tPublisher = session.createPublisher(topic);
			ObjectMessage message = session.createObjectMessage("orderIds");
			conn.start();
			tPublisher.publish(message);
		} catch (NamingException e){
			e.printStackTrace();
		} catch(JMSException e){
			e.printStackTrace();
		} finally{
			if(context != null){
				try{
					context.close();
				} catch (NamingException e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				} catch (JMSException e){
					e.printStackTrace();
				}
			}
		}
	}
}
