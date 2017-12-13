package com.webservice.entity;

import java.util.Date;

public class OAMClientReceiver {
	private String clientId;
	private String partnerId;
	private String from;
	private String to;
	private String telco;
	private String status;
	private String timestamp;
	private String username;
	private String passToken;
	private String rand;
	public OAMClientReceiver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OAMClientReceiver(String clientId, String partnerId, String from, String to, String telco, String status,
			String timestamp, String username, String passToken, String rand) {
		super();
		this.clientId = clientId;
		this.partnerId = partnerId;
		this.from = from;
		this.to = to;
		this.telco = telco;
		this.status = status;
		this.timestamp = timestamp;
		this.username = username;
		this.passToken = passToken;
		this.rand = rand;
	}

	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getTelco() {
		return telco;
	}
	public void setTelco(String telco) {
		this.telco = telco;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassToken() {
		return passToken;
	}
	public void setPassToken(String passToken) {
		this.passToken = passToken;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
	
}
