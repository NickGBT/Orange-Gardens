import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class ExampleListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			messagetosend messagetosend = (MessageToSend) objectMessage.getObject();
			System.out.println(messagetosend.toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}