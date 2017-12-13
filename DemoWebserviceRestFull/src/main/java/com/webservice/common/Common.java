package com.webservice.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Common {
	
	///private static Properties prop;
	
	private static final Logger log = LoggerFactory.getLogger(Common.class);
	

	public static String MD5(String pass) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pass.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();

	}

	public static String SHA256(String inp) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(inp.getBytes("UTF-8")); // Change this to "UTF-16" if
												// needed
			byte[] digest = md.digest();
			return String.format("%064x", new java.math.BigInteger(1, digest));
		} catch (Exception e) {
			log.error("Error SHA26: ", e);
			return null;
		}
	}
	
	
	
	// generate random string
	public static String genRand() {
		int length = 10;
		String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder rand = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ){ 
			   rand.append( alphanum.charAt( random.nextInt(alphanum.length()) ) );
		   }
		return rand.toString();
	}

}
