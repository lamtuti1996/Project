package com.azplay.azpotal.azgate.sc.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azplay.azpotal.azgate.sc.entity.Client;
import com.azplay.azpotal.azgate.sc.model.MTReceiver;

import spark.Request;


public class Common {
	
	///private static Properties prop;
	
	private static final Logger log = LoggerFactory.getLogger(Common.class);
	
	public static boolean validate(Request req) {
		if (req == null) {
			return false;
		}
		// check null parameters
		if (req.queryParams("mo_id") == null || req.queryParams("sender") == null || req.queryParams("serviceId") == null
				|| req.queryParams("message") == null || req.queryParams("operator") == null || req.queryParams("commandCode") == null
				|| req.queryParams("key") == null || req.queryParams("username") == null) {
			return false;
		}
		if (Constant.STR_EMTY.equals(req.queryParams("mo_id"))|| Constant.STR_EMTY.equals(req.queryParams("sender"))
				|| Constant.STR_EMTY.equals(req.queryParams("serviceId")) || Constant.STR_EMTY.equals(req.queryParams("message"))
				|| Constant.STR_EMTY.equals(req.queryParams("operator"))
				|| Constant.STR_EMTY.equals(req.queryParams("commandCode")) || Constant.STR_EMTY.equals(req.queryParams("key"))
				|| Constant.STR_EMTY.equals(req.queryParams("username"))) {
			return false;
		}
		return true;
	}

	public static MTReceiver validateMT(Request req) {
		MTReceiver mtReceiver = new MTReceiver();
		if (req == null) {
			return null;
		}
		// check null parameters
		if (req.queryParams("moId") == null || req.queryParams("sc") == null || req.queryParams("msisdn") == null
				|| req.queryParams("content") == null || req.queryParams("mtType") == null
				|| req.queryParams("timeStamp") == null || req.queryParams("clientId") == null
				|| req.queryParams("passToken") == null || req.queryParams("rand") == null) {

			return null;
		} else if (req.queryParams("moId") == Constant.STR_EMTY || req.queryParams("sc") == Constant.STR_EMTY
				|| req.queryParams("msisdn") == Constant.STR_EMTY || req.queryParams("content") == Constant.STR_EMTY
				|| req.queryParams("mtType") == Constant.STR_EMTY || req.queryParams("timeStamp") == Constant.STR_EMTY
				|| req.queryParams("clientId") == Constant.STR_EMTY || req.queryParams("passToken") == Constant.STR_EMTY
				|| req.queryParams("rand") == Constant.STR_EMTY) {

			return null;
		} else {
			mtReceiver.setClientId(req.queryParams("clientId"));
			mtReceiver.setContent(req.queryParams("content"));
			mtReceiver.setMOId(req.queryParams("moId"));
			mtReceiver.setMsisdn(req.queryParams("msisdn"));
			mtReceiver.setMtType(req.queryParams("mtType"));
			mtReceiver.setRand(req.queryParams("rand"));
			mtReceiver.setSc(req.queryParams("sc"));
			mtReceiver.setPassToken(req.queryParams("passToken"));
			mtReceiver.setTimeStamp(req.queryParams("timeStamp"));
			log.debug("=============MT Receiver==========");
			log.debug(req.queryParams("clientId"));
			log.debug(req.queryParams("content"));
			log.debug(req.queryParams("moId"));
			log.debug(req.queryParams("msisdn"));
			log.debug(req.queryParams("mtType"));
			log.debug(req.queryParams("rand"));
			log.debug(req.queryParams("sc"));
			log.debug(req.queryParams("passToken"));
			log.debug(req.queryParams("timeStamp"));
			return mtReceiver;
		}
	}

	public static String MD5(String pass) throws NoSuchAlgorithmException {
//		MessageDigest m = MessageDigest.getInstance("MD5");
//		byte[] data = pass.getBytes();
//		m.update(data, 0, data.length);
//		BigInteger i = new BigInteger(1, m.digest());
//		return String.format("%1$032X", i);
		
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
	
	public static String convertTelco(String telco){
		switch (telco) {
		case "VMS":
			telco = "MBF";
			break;
		case "GPC":
			telco = "VNP";
			break;
		case "VIETTEL":
			telco = "VTT";
			break;
		case "BL":
			telco = "GMB";
			break;
		default:
			break;
		}
		return telco;
	}
	
	public static String reconvertTelco(String telco){
		switch (telco) {
		case "MBF":
			telco = "VMS";
			break;
		case "VNP":
			telco = "GPC";
			break;
		case "VTT":
			telco = "VIETTEL";
			break;
		case "GMB":
			telco = "BL";
			break;
		default:
			break;
		}
		return telco;
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
	
	public static String getPassTokenMT(MTReceiver mtReceiver, Client clientData){
		String passToken = "";
		passToken = mtReceiver.getTimeStamp() + "|" + mtReceiver.getRand() + "|" 
				+ mtReceiver.getClientId() + "|" +  clientData.getClientPass() + "|"
				+ mtReceiver.getMOId() + "|" +  mtReceiver.getMsisdn() + "|"
				+ mtReceiver.getMtType() + "|" 
				+ mtReceiver.getContent()+ "|"
				+ mtReceiver.getSc();
		return passToken;
	}
}
