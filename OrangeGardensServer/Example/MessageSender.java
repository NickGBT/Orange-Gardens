import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class MessageSender {
	private Context context;
	private QueueConnectionFactory connectionFactory;
	private Destination destination;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	private ObjectMessage objectMessage;
	
	public void sendObjectMessage() {
		try {
			context = new InitialContext();
			connectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			destination = (Queue) context.lookup("messagequeue");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(destination);
			MessageToSend message = new MessageToSend(1);
			objectMessage = session.createObjectMessage(message);
			connection.start();
			messageProducer.send(objectMessage);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}