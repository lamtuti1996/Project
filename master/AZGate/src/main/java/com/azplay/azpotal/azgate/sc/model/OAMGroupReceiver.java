package com.azplay.azpotal.azgate.sc.model;

import java.util.Date;

public class OAMGroupReceiver {
	private String clientId;
	private String partnerId;
	private Date from;
	private Date to;
	private String telco;
	private String status;
	private String timestamp;
	private String username;
	private String passToken;
	private String rand;

	public OAMGroupReceiver(String clientId, String partnerId, Date from, Date to, String telco, String status,
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

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
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

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
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

}
