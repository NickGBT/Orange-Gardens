package dops;

import java.util.ArrayList;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 
 * @author Alexander Neil
 *
 */

public class JMSConnector implements MessageListener {

	ArrayList<Integer> activeEmployees;
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
