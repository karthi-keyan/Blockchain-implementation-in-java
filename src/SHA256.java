import java.security.*;

//to compute SHA-256 algorithm
public class SHA256{

	public String converttohash(String message){   
		String hashCode=null;
		try {
		MessageDigest encrypt = MessageDigest.getInstance("SHA-256");
		byte[] hash = encrypt.digest(message.getBytes());
		StringBuffer sb =new StringBuffer();
		for(byte b : hash){
			sb.append(String.format("%02x", b& 0xff));
		}
		hashCode=sb.toString();
        }
	    catch(Exception e){
	    	System.out.println("Error occured");
	    }
	  return hashCode;
	  
	}
}