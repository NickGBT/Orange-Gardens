package com.netbuilder.dops.jms;

import java.io.Serializable;

import com.netbuilder.entities.Order;

public class OrderMessage implements Serializable {

	private static final long serialVersionUID = 20150729L;
	
	private Order order;
	private int messageId;

	public OrderMessage(int messageId, Order order){
		this.messageId = messageId;
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
