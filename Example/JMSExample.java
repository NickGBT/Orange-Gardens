
public class JMSExample {

	public static void main(String[] args) {
		MessageReceiver receiver = new MessageReceiver();
		MessageSender sender = new MessageSender();
		receiver.receiveObjectMessage();
		sender.sendObjectMessage();
	}
}