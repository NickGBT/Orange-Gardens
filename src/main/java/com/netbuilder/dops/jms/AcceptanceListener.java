package com.netbuilder.dops.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

public class AcceptanceListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		/*
		 * Takes a message with an employee's user ID and the order ID they are accepting.
		 */
	}

}
