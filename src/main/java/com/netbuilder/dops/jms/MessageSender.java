package com.netbuilder.dops.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.netbuilder.entities.Order;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;


/**
 * 
 * @author Alexander Neil
 *
 */
/*
 * ANGRY!
 */
public class MessageSender {

	private static int messageId = 0;
	
	private Context context = null;
	private QueueConnectionFactory connFactory = null;
	private QueueConnection conn = null;
	private Queue queue = null;
	private QueueSession session = null;
	private QueueSender qSender = null;
	
	public void sendOrderMessage(Order order, int employeeId){
		try{
			context = new InitialContext();
			connFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			queue = (Queue) context.lookup("" + employeeId);
			conn = connFactory.createQueueConnection();
			session = conn.createQueueSession(false, AUTO_ACKNOWLEDGE);
			qSender = session.createSender(queue);
			OrderMessage oMessage = new OrderMessage(messageId++, order);
			ObjectMessage objectMessage = session.createObjectMessage(oMessage);
			conn.start();
			qSender.send(objectMessage);
			
		} catch(NamingException ne){
			ne.printStackTrace();
		} catch(JMSException jmse){
			jmse.printStackTrace();
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
				} catch(JMSException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void broadcastAvailableOrder(){
		
	}
}
