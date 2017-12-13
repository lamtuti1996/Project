package com.springboot.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		// MessageDigest m = MessageDigest.getInstance("MD5");
		// byte[] data = pass.getBytes();
		// m.update(data, 0, data.length);
		// BigInteger i = new BigInteger(1, m.digest());
		// return String.format("%1$032X", i);

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(pass.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();

	}

	public static Date CurrentDateTime() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long dateTime = System.currentTimeMillis();
		String temp = dateFormat.format(dateTime);
		Date date = dateFormat.parse(temp);
		return date;
	}
}
