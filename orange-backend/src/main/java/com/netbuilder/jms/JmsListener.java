package com.netbuilder.jms;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class JmsListener implements MessageListener
{
	private static final Logger logger = LogManager.getLogger();
	private final JmsMessageHandler handler;
	
	public JmsListener(JmsMessageHandler source)
	{
		this.handler = source;
	}

	@Override
	public void onMessage(Message message)
	{
		logger.info("Message received", message);

		logger.debug("Checking instance of message", message);
		if (message instanceof TextMessage)
		{
			try
			{
				String payload = ((TextMessage)message).getText();
				
				logger.debug("Handling TextMessage payload", payload);
				//handle string message
			} 
			catch (JMSException e)
			{
				logger.error("Error in message conversion to TextMessage", e);
				e.printStackTrace();
			}
		}
		else if (message instanceof ObjectMessage)
		{
			try 
			{
				Object payload = ((ObjectMessage)message).getObject();

				logger.debug("Checking payload class type of ObjectMessage", payload);
				
				if (payload instanceof List<?>)
				{
					//handle list message
				}
			} 
			catch (JMSException e)
			{
				logger.error("Error in message conversion to ObjectMessage", e);
				e.printStackTrace();
			}
		}
	}
}