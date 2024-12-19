package whatsAppMassenger;

import java.net.URI;
import java.time.LocalDateTime;

public class ImageMessage extends Message{
	
	private URI imageUrl;

	public ImageMessage(String sender, String receiver, String content, LocalDateTime timestamp, URI imageUrl) {
		super(sender, receiver, content, timestamp);
		// TODO Auto-generated constructor stub
		
		this.imageUrl = imageUrl;
	}

	public URI getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(URI imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "ImageMessage [imageUrl=" + imageUrl + ", getImageUrl()=" + getImageUrl() + ", getSender()="
				+ getSender() + ", getReceiver()=" + getReceiver() + ", getContent()=" + getContent()
				+ ", getTimestamp()=" + getTimestamp() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
