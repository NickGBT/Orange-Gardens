package com.netbuilder.controllers;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.jms.QueueSenderBean;

@ManagedBean(name = "messageController")
@RequestScoped
public class MessageController 
{
	@Inject
	private QueueSenderBean qb;
	
	private String textMessage = "Hello from Message Controller!";

	public void sendTextMessage()
	{
		System.out.println("SENDING");
		qb.sendMessage(textMessage);
	}
	
	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
}
