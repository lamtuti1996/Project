/**
 * 
 */
package com.azplay.azpotal.azgate.sc.model;

import java.sql.Timestamp;

/**
 * @author thang
 *
 */
public class MORequest {
	private String moId;
	private String msisdn;
	private String sc;
	private String content;
	private String telco;
	private Timestamp timeStamp;
	private String rand;
	private String clientId;
	private String tokenPass;

	public MORequest() {

	}

	public MORequest(String moId, String msisdn, String sc, String content, String telco, Timestamp timeStamp, String rand,
			String clientId, String tokenPass) {
		super();
		this.moId = moId;
		this.msisdn = msisdn;
		this.sc = sc;
		this.content = content;
		this.telco = telco;
		this.timeStamp = timeStamp;
		this.rand = rand;
		this.clientId = clientId;
		this.tokenPass = tokenPass;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getMOId() {
		return moId;
	}

	public void setMOId(String moId) {
		this.moId = moId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTelco() {
		return telco;
	}

	public void setTelco(String telco) {
		this.telco = telco;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getTokenPass() {
		return tokenPass;
	}

	public void setTokenPass(String tokenPass) {
		this.tokenPass = tokenPass;
	}

}
