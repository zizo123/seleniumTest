package toto.koko;

import java.util.Base64;

/**
 * Hello world!
 *
 */
public class Password 
{
    public static void main( String[] args )
    {
    	
    	String password = "test";
    	String passwordEncoded = new String(Base64.getEncoder().encode(password.getBytes()));
    	System.out.println(passwordEncoded);
    	
    	String passwordDecoder = new String(Base64.getDecoder().decode(passwordEncoded.getBytes()));
    	System.out.println(passwordDecoder);
    }
}
