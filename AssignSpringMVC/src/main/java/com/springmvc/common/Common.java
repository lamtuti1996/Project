package com.springmvc.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	// generate random string
	public static String genRand() {
		int length = 10;
		String alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder rand = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			rand.append(alphanum.charAt(random.nextInt(alphanum.length())));
		}
		return rand.toString();
	}

	public static String MD5(String pass) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		byte[] data = pass.getBytes();
		m.update(data, 0, data.length);
		BigInteger i = new BigInteger(1, m.digest());
		return String.format("%1$032X", i);
	}

	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String stringDate = dateFormat.format(date);
		return stringDate;
	}

	public static String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String stringDate = dateFormat.format(date);
		return stringDate;
	}

}
