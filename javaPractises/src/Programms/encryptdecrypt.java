package Programms;
import java.util.Base64;

public class encryptdecrypt {

	public static void main(String[] args) {
		//code for encryption
		
		String str = "prathamesh";
		Base64.Encoder encoder = Base64.getEncoder();
		String abc = encoder.encodeToString(str.getBytes());
		System.out.println(abc);
		
		// code for decryption
		
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decrptedstr = decoder.decode(abc);
		String decodedStr = new String(decrptedstr);
		System.out.println(decodedStr);
	}

}
