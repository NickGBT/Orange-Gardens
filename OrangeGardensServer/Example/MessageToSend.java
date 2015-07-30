import java.io.Serializable;


public class MessageToSend implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int messageID;
	private String message = "Hello Guys";
	
	public MessageToSend(int messageID) {
		this.messageID = messageID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getMessageID() {
		return messageID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}