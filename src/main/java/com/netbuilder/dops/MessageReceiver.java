package com.netbuilder.dops;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * 
 * @author Alexander Neil
 *
 */
public class MessageReceiver {

	private Context context = null;
	private QueueConnectionFactory connFactory = null;
	private QueueConnection conn = null;
	private Queue queue = null;
	private QueueSession session = null;
	private QueueReceiver qReceiver = null;
	
	public void receiverOrderAcceptance(){
		try{
			context = new InitialContext();
			connFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			queue = (Queue) context.lookup("orderaccept");
			conn = connFactory.createQueueConnection();
			session = conn.createQueueSession(false, AUTO_ACKNOWLEDGE);
			qReceiver = session.createReceiver(queue);
			conn.start();
			qReceiver.setMessageListener(new AcceptanceListener()); //TODO
		} catch (NamingException e){
			e.printStackTrace();
		} catch (JMSException e){
			e.printStackTrace();
		} finally {
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
				} catch(JMSException e){
					e.printStackTrace();
				}
			}
		}
	}
}
