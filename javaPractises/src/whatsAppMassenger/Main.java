package whatsAppMassenger;

import java.net.URI;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Message msg = new TextMessage("prathamesh", "rohit", "i am going to college", LocalDateTime.now());
		
		System.out.println(msg);
		
        Message ImgMessage = new ImageMessage("prathamesh", "rohit", "i am going to college", LocalDateTime.now(),  URI.create("https://example.com/image.jpg"));
		
		System.out.println(ImgMessage);

	}

}
