package whatsAppMassenger;

import java.time.LocalDateTime;

public class TextMessage extends Message{

	public TextMessage(String sender, String receiver, String content, LocalDateTime timestamp) {
		super(sender, receiver, content, timestamp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TextMessage [getSender()=" + getSender() + ", getReceiver()=" + getReceiver() + ", getContent()="
				+ getContent() + ", getTimestamp()=" + getTimestamp() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
